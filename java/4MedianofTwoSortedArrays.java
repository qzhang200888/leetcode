class Solution {
    double findMedian(int[] nums) {
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        }
        
        return nums[nums.length / 2];
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return findMedian(nums2);
        if (nums2 == null || nums2.length == 0)
            return findMedian(nums1);
        
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        
        int start = 0, end = nums1.length;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            int partition = (nums1.length + nums2.length + 1) / 2 - mid;
            
            int left1 = mid > 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int left2 = partition > 0 ? nums2[partition - 1] : Integer.MIN_VALUE;
            
            int right1 = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int right2 = partition < nums2.length ? nums2[partition] : Integer.MAX_VALUE;  
    
            int maxLeft = Math.max(left1, left2);
            int minRight = Math.min(right1, right2);
 
            if (maxLeft <= minRight) {
                if ((nums1.length + nums2.length) % 2 == 0)
                    return (maxLeft + minRight) / 2.0;
                return maxLeft;
            }
            
            if (left1 > right2)
                end = mid - 1;
            else start = mid + 1;
        }
        
        return -1;
    }
}
