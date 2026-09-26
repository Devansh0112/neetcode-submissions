class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for elem in strs:
            sorted_string = "".join(sorted(elem))
            if sorted_string not in res:
                res[sorted_string] = []

            res[sorted_string].append(elem)

        return list(res.values())