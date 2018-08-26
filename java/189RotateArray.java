class Solution {
    void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            
            ++start;
            --end;
        }
    }
    
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return;
        
        k %= nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
}
