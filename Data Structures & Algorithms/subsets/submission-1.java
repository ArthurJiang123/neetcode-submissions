class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int i, int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (i == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        // include nums[i]
        cur.add(nums[i]);
        backtrack(i + 1, nums, cur, res);

        // exclude nums[i]
        cur.remove(cur.size() - 1);
        backtrack(i + 1, nums, cur, res);
    }
}
