class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        substring = set()
        res = 1

        l, r = 0, 0

        while r < len(s):
            if s[r] in substring:
                res = max(res, len(substring))
                while s[r] in substring:
                    substring.remove(s[l])
                    l += 1
            
            substring.add(s[r])
            r += 1


        return max(res,r-l)
