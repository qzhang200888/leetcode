class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                
                int k = j;
                while (k < n - 1 && nums2[k] > nums2[k + 1]) {
                    temp = nums2[k];
                    nums2[k] = nums2[k + 1];
                    nums2[k + 1] = temp;
                    ++k;
                }
            }
            
            ++i;
        }
        
        if (i == m) {
            while (j < n)
                nums1[i++] = nums2[j++];
        }
    }
}
///

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length == 0)
            return;
        
        int pos = m + n - 1;
        int first = m - 1, second = n - 1;
        while (first >= 0 && second >= 0) {
            if (nums1[first] >= nums2[second]) {
                nums1[pos--] = nums1[first--];
            } else {
                nums1[pos--] = nums2[second--];
            }
        }
        
        while (second >= 0) {
            nums1[pos--] = nums2[second--];
        }
    }
}
