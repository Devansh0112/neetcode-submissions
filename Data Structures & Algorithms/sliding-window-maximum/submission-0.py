class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        if not nums or k <= 0:
            return []
        
        n = len(nums)
        
        if k > n:
            return [max(nums)]
        
        if k == 1:
            return list(nums)
        
        dq = deque()
        res = []
        
        for i in range(n):
            if dq and dq[0] <= i - k:
                dq.popleft()
                
            while dq and nums[dq[-1]] <= nums[i]:
                dq.pop()
                
            dq.append(i)
            
            if i >= k - 1:
                res.append(nums[dq[0]])
                
        return res