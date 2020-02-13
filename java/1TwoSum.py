class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        d = {}
        for i, num in enumerate(nums):
            d[num] = i
        for i, num in enumerate(nums):
            ix = d.get(target - num)
            if ix and ix != i:
                resp = [i, d[target - num]]
                return resp
