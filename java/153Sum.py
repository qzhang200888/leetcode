class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        C=collections.Counter(nums)
        finds,results,bisl=sorted(C),set([(0,0,0)]) if C[0]>=3 else set(),bisect.bisect_left
        for i,k1 in enumerate(finds):
            if C[k1]>1 and -2*k1 in C and k1:   results.add((k1,k1,-2*k1))
            if k1<0:
                for k2 in finds[bisl(finds,-finds[-1]-k1,i+1):bisl(finds,math.ceil(-k1/2),i+1)]:
                    if -(k1+k2) in C:results.add((k1,k2,-k1-k2))
        return results
