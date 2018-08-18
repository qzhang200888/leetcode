class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[]{};

        if (nums1.length > nums2.length)
            return intersect(nums2, nums1);
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i)
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);

        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; ++i) {
            if (map.containsKey(nums2[i])) {
                res.add(nums2[i]);
                
                int fre = map.get(nums2[i]);
                if (fre == 1)
                    map.remove(nums2[i]);
                else map.put(nums2[i], fre - 1);
            }
        }

        int[] resArr = new int[res.size()];
        int i = 0;
        for (int v: res)
            resArr[i++] = v;
            
        return resArr; 
    }
}
