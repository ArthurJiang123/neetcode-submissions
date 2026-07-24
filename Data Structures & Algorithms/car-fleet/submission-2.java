class Solution {

    /*
        1. add position[i], speed[i] to a List<int[]>
        2. sort the list in desc, by position (from far to close) 
        3. Use a stack that stores unique car fleets
        4. Iterate over the position & speed arrays:
            4.1 calculate #minutes to arrive Target
                case1: #minutes < top of the stack
                    this car will be a part of the existing fleet
                    So ignore it
                case2: #minutes > top of the stack
                    push the #minutes to the top
        5. return the size of the stack
    */

    public int carFleet(int target, int[] position, int[] speed) {
        
        List<int[]> position_speed = new ArrayList<>();
        for(int i = 0 ; i < position.length; i++){
            position_speed.add(new int[]{position[i], speed[i]});
        }


        // Sort by position in descending order (closest to target first)
        Collections.sort(position_speed, (a, b) -> b[0] - a[0]);

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < position_speed.size(); i++){
            int[] pos_speed = position_speed.get(i);
            // Use double to prevent integer division truncation
            double minutes = (double)(target - pos_speed[0]) / pos_speed[1];
            if(stack.isEmpty() || minutes > stack.peek()){
                stack.push(minutes);
            }
        }
        return stack.size();
    }
}
