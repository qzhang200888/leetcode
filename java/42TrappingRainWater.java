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

// 变体(-1 表示漏水， V存的水都能漏下)

class Solution {
    int trap(int[] height, int start, int end) {
        if (start >= end)
            return 0;
        
        int max = 0;
        int max_index = -1;
        for (int i = start; i <= end; ++i) {
            if (max < height[i]) {
                max = height[i];
                max_index = i;
            }
        }
        
        int curHeight = 0;
        int water = 0;
        for (int i = start; i < max_index; ++i) {
            if (curHeight < height[i])
                curHeight = height[i];
            else water += curHeight - height[i];
        } 
        
        curHeight = 0;
        for (int i = end; i > max_index; --i) {
            if (curHeight < height[i])
                curHeight = height[i];
            else water += curHeight - height[i];
        }
        
        return water;
    }
    
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        
        List<Integer> breaks = new ArrayList<>();
        
        breaks.add(-1);
        for (int i = 0; i < height.length; ++i) {
            if (height[i] == -1)
                breaks.add(i);
        }
        
        breaks.add(height.length);
        
        int water = 0;
        for (int i = 0; i < breaks.size() - 1; ++i) {
            water += trap(height, breaks.get(i) + 1, breaks.get(i + 1) - 1);
        }
            
        return water;
    }
}
