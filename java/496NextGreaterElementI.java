class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextElements = new int[nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                nextElements[stack.pop()] = nums2[i];
            }
            
            stack.push(i);
            map.put(nums2[i], i);
        }
        
        while (!stack.isEmpty())
            nextElements[stack.pop()] = -1;
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = nextElements[map.get(nums1[i])];
        }
        
        return res;
    }
}
