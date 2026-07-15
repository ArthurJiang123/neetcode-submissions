class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[0], int2[0]));
        
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            int result_size = result.size();
            int[] curr = intervals[i];
            int[] prev = result.get(result_size - 1);
            
            if(curr[0] <= prev[1]){
                prev[1] = Math.max(curr[1], prev[1]);
            }else{
                result.add(curr);
            }            
        }    

        return result.toArray(new int[result.size()][2]);
    }
}
