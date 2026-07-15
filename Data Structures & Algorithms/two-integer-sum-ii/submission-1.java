class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int pt1 = 0;
        int pt2 = numbers.length-1;
        int result = 0;
        while(pt1 < pt2){
            result = numbers[pt1] + numbers[pt2];
            if(result == target) return new int[]{pt1+1, pt2+1};
            else if (result < target) pt1++;
            else pt2--;
        }
        return new int[]{1, 1};
    }
}
