class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
            
        longest = 0
        nums.sort()

        i = 1
        count = 1
        while i < len(nums):
            if nums[i] == nums[i-1] + 1:
                count += 1
            elif nums[i] != nums[i-1]:
                longest = max(longest, count)
                count = 1

            i += 1

        return max(longest, count)