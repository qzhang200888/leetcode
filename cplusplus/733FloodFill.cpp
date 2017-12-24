class Solution {
public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor)
            changeColor(image, sr, sc, image[sr][sc], newColor);
        
        return image;
    }
    
    void changeColor(vector<vector<int>>& image, int cx, int cy, int originColor, int newColor) {
        if (cx < 0 || cy < 0 || cx >= image.size() || cy >= image[0].size())
            return;
        
        if (image[cx][cy] == originColor) {
            image[cx][cy] = newColor;
        
            changeColor(image, cx + 1, cy, originColor, newColor);
            changeColor(image, cx - 1, cy, originColor, newColor);
            changeColor(image, cx, cy + 1, originColor, newColor);
            changeColor(image, cx, cy - 1, originColor, newColor);
        }
    }
};
