class Solution {
    int find(int[] arr, int x) {
        if (x <= arr[0])
            return -1;
        if (x >= arr[arr.length - 1])
            return arr.length;
        
        int i = 0, j = arr.length;
        while (i < j - 1) {
            int mid = (i + j) / 2;
            if (arr[mid] > x)
                j = mid;
            else i = mid;
        }
        
        return i;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> lst = new LinkedList<>();
        
        int index = find(arr, x);
        if (index < 0) {
            for (int i = 0; i < k; ++i)
                lst.add(arr[i]);
        } else if (index >= arr.length) {
            for (int i = arr.length - 1; i >= arr.length - k; --i)
                lst.add(arr[i]);
            Collections.reverse(lst);
        } else {
            int i = index, j = index + 1;
            
            while (lst.size() < k) {
                if (i >= 0 && j < arr.length) {
                    if (x - arr[i] <= arr[j] - x) {
                        lst.add(arr[i]);
                        --i;
                    } else {
                        lst.add(arr[j]);
                        ++j;
                    }
                } else if (i >= 0) {
                    lst.add(arr[i]);
                    --i;                    
                } else {
                    lst.add(arr[j]);
                    ++j;                    
                }
            }
            
            Collections.sort(lst);
        }
        
        return lst;
    }
}
