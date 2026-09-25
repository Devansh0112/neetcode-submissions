class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rt, rb = 0, len(matrix)- 1
        ll, lr = 0, len(matrix[0]) -1 

        while rt <= rb:
            mid = rt + (rb - rt) // 2
            if matrix[mid][ll] <= target <= matrix[mid][lr]:
                rt = mid
                break
            else:
                if matrix[mid][lr] < target:
                    rt = mid + 1
                if matrix[mid][ll] > target:
                    rb = mid - 1

        if rt > rb:
            return False

        while ll <= lr:
            mid = ll + (lr - ll) // 2
            if matrix[rt][mid] == target:
                return True
            if matrix[rt][mid] < target:
                ll = mid + 1
            else:
                lr = mid - 1
            

        return False