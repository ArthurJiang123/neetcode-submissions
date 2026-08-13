class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for(int num : nums){
            if(uniqueNums.contains(num)) return num;
            uniqueNums.add(num);
        }

        return 0;
    }
}
