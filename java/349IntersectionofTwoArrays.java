class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return new int[0];
        if (nums2 == null || nums2.length == 0)
            return new int[0];
        
        if (nums1.length > nums2.length)
            return intersection(nums2, nums1);
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i)
            set.add(nums1[i]);
        
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (set.contains(nums2[i])) {
                lst.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        
        int[] res = new int[lst.size()];
        int i = 0;
        for (int v: lst) {
            res[i++] = v;
        }
        
        return res;
    }
}
