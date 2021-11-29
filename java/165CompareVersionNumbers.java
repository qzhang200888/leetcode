class Solution {
    public int compareVersion(String version1, String version2) {
        String[] leftStrs = version1.split("\\.");
        String[] rightStrs = version2.split("\\.");
        int i = 0;
        while (i < leftStrs.length && i < rightStrs.length) {
            int i1 = Integer.parseInt(leftStrs[i]);
            int i2 = Integer.parseInt(rightStrs[i]);
            
            if (i1 < i2)
                return -1;
            if (i2 < i1)
                return 1;
            ++i;
        }
        
        while (i < leftStrs.length) {
            int i1 = Integer.parseInt(leftStrs[i]);
            if (i1 > 0)
                return 1;
            ++i;
        }
        
        while (i < rightStrs.length) {
            int i2 = Integer.parseInt(rightStrs[i]);

            if (i2 > 0)
                return -1;
            ++i;
        }
        
        return 0;
    }
}
