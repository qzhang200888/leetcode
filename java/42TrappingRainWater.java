class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        int max = 0;
        int max_index = -1;
        for (int i = 0; i < height.length; ++i) {
            if (max < height[i]) {
                max = height[i];
                max_index = i;
            }
        }
        
        int curHeight = 0;
        int water = 0;
        for (int i = 0; i < max_index; ++i) {
            if (curHeight < height[i])
                curHeight = height[i];
            else water += curHeight - height[i];
        } 
        
        curHeight = 0;
        for (int i = height.length - 1; i > max_index; --i) {
            if (curHeight < height[i])
                curHeight = height[i];
            else water += curHeight - height[i];
        }
        
        return water;
    }
}
