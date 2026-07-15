class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        List<int[]> result = new ArrayList<>();
        boolean added = false;
       
        for(int i = 0; i < intervals.length; i++){
            int left = intervals[i][0];
            if (left > newInterval[0] && !added){
                result.add(newInterval);
                added = true;
            }
            result.add(intervals[i]);
        }
        if(!added){
            result.add(newInterval);
        }

        boolean noOverlap = false;
        boolean overlapped = false;
        while(!noOverlap){
            int i = 1;
            overlapped = false;
            while(i < result.size()){
                int[] prev = result.get(i-1);
                int[] curr = result.get(i);
                if(isOverlap(prev, curr)){
                    merge(prev, curr);
                    result.remove(i);
                    overlapped = true;
                    break;
                }else{
                    i++;
                }
            }
            if(!overlapped) noOverlap = true;
        }

        return result.toArray(new int[0][0]);

    }
    private void merge(int[] a, int[] b){
        int[] result = new int[2];
        result[0] = Math.min(a[0], b[0]);
        result[1] = Math.max(a[1], b[1]);
        a[0] = result[0];
        a[1] = result[1];
    }

    private boolean isOverlap(int[] small, int[] big){
        if (small[0] == big[0] || small[1] == big[1]){
            return true;
        }

        if (small[0] > big[0]){
            int[] temp = small;
            small = big;
            big = small;
        }

        return big[0] <= small[1] || big[1] <= small[1];
    }
}
