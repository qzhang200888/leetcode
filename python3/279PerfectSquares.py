class Solution:
    def numSquares(self, n):
        """
        :type n: int
        :rtype: int
        """
        array = [0] * (n + 1)
        
        idx = 1
        while idx < len(array):
            index = 1
            array[idx] = n
            while index * index <= idx:
                if array[idx - index * index] + 1 < array[idx]:
                    array[idx] = array[idx - index * index] + 1
                index += 1
            idx += 1
        return array[n]
