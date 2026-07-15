class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, 0, target, nums, cur, result);
        return result;
    }

    public void backtrack(int index, int cursum, int target, int[] nums,
                            List<Integer> cur, List<List<Integer>> result){
        // base case (leaves): 
        // (1) cursum + nums[index] = target
        // (2) reaches the end of the array
        if(cursum == target){
            result.add(new ArrayList<>(cur));
            return;
        }else if(index == nums.length){
            return;
        }

        // (left branch) divisible by itself -> reuse itself
        if(nums[index] <= target-cursum){
            cur.add(nums[index]);
            backtrack(index, cursum+nums[index], target, nums, cur, result);
            cur.remove(cur.size()-1);
        }

        // (right branch) not divisible by itself -> probe the next number
        backtrack(index+1, cursum, target, nums, cur, result);
    }
}
