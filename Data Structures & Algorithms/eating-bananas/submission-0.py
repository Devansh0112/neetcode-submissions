class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low = 1
        high = max(piles)

        while low < high:
            mid = (high + low) // 2
            hours_needed = sum((p + mid - 1) // mid for p in piles)

            if hours_needed <= h:
                high = mid
            else:
                low = mid + 1

        return low