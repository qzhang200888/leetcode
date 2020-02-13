class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s = ''.join(e.lower() for e in s if e.isalnum())
        
        left = 0
        right = len(s)-1
        
        while left<right:
            if s[left]!=s[right]:
                return False
            left+=1
            right-=1
        
        return True   
