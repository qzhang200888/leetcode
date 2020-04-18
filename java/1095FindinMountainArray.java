/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    int findPeak(MountainArray mountainArr) {
        int s = 0, e = mountainArr.length() - 1;
        while (s < e - 1) {
            int m = (s + e) / 2;
            if (mountainArr.get(m) > mountainArr.get(m - 1) && mountainArr.get(m) > mountainArr.get(m + 1))
                return m;
            if (mountainArr.get(m) > mountainArr.get(m - 1))
                s = m;
            else e = m;
        }
                
        if (mountainArr.get(s) < mountainArr.get(e))
                return e;
        return s;
    }
                
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int p = findPeak(mountainArr);
        if (mountainArr.get(p) < target)
            return -1;

        int s = 0, e = p;        
        while (s < e -  1) {
            int m = (s + e) / 2;
            if (mountainArr.get(m) > target)
                e = m;
            else if (mountainArr.get(m) < target)
                s = m;
            else return m;
        }
        
        if (mountainArr.get(s) == target)
            return s;
        if (mountainArr.get(e) == target)
            return e;
        
        s = p + 1;
        e = mountainArr.length() - 1;

        while (s < e -  1) {
            int m = (s + e) / 2;
            if (mountainArr.get(m) < target)
                e = m;
            else if (mountainArr.get(m) > target)
                s = m;
            else return m;
        }
        if (mountainArr.get(s) == target)
            return s;
        if (mountainArr.get(e) == target)
            return e;
        
        return -1;
    }
}
