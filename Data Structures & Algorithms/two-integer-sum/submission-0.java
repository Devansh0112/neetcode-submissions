class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> diff_map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (diff_map.containsKey(diff)) {
                return new int[]{diff_map.get(diff), i};
            }
            diff_map.put(nums[i], i);
        }
        return new int[]{};
    }
}
