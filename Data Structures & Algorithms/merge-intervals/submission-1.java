class Solution {
    public int[][] merge(int[][] intervals) {

        Comparator<int[]> comparator = (int1, int2) -> Integer.compare(int1[0], int2[0]);
        List<int[]> result = new ArrayList<>(Arrays.asList(intervals));
        result.sort(comparator);

        int i = 1;
        while(i < result.size()){
            int[] int1 = result.get(i-1);
            int[] int2 = result.get(i);
            if(int1[1] >= int2[0]){
                result.remove(i-1);
                result.remove(i-1);
                int new_left = Math.min(int1[0], int2[0]);
                int new_right = Math.max(int1[1], int2[1]);

                result.add(i-1, new int[]{new_left, new_right});
                continue;
            }else{
                i++;
            }
        }
        return result.toArray(new int[0][0]);
    }
}
