class Solution {
    /**
     * Approach: Sort by position, then use a Monotonic Stack
     * 
     * Key Insight: Process cars from closest to farthest from target.
     * A car can only join a fleet ahead of it, never affect cars behind it.
     * 
     * Time: O(n log n) — Sorting: O(n log n), Single pass: O(n)
     * Space: O(n) — Array/List: O(n), Stack: O(n) worst case
     */
    public int carFleet(int target, int[] position, int[] speed) {
        // 1. Pair each car's position with its speed
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        
        // 2. Sort descending by position (process cars closest to target first)
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        
        // 3. Use monotonic stack to track fleet arrival times
        //    Stack only grows when a new slower fleet forms
        Stack<Double> fleetTimes = new Stack<>();
        
        for (int[] car : cars) {
            // Time to reach target = remaining distance / speed
            double timeToTarget = (double)(target - car[0]) / car[1];
            
            // If this car arrives later than the fleet ahead, it forms a new fleet
            // If it arrives at same time or earlier, it joins the fleet ahead
            if (fleetTimes.isEmpty() || timeToTarget > fleetTimes.peek()) {
                fleetTimes.push(timeToTarget);
            }
            // else: car catches up and merges → skip (no push)
        }
        
        return fleetTimes.size();
    }
}
