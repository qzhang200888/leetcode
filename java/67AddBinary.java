class Solution {
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        
        int i = arr1.length - 1, j = arr2.length - 1;
        int carrier = 0;
        StringBuilder sb = new StringBuilder();
        
        while (i >= 0 && j >= 0) {
            int v1 = arr1[i] - '0';
            int v2 = arr2[j] - '0';
            
            sb.append((v1 + v2 + carrier) % 2);
            carrier = (v1 + v2 + carrier) / 2;
            
            --i;
            --j;
        }
 
        while (i >= 0) {
            int v = arr1[i] - '0';
            
            sb.append((v + carrier) % 2);
            carrier = (v + carrier) / 2;
            
            --i;
        }
        
        while (j >= 0) {
            int v = arr2[j] - '0';
            
            sb.append((v + carrier) % 2);
            carrier = (v + carrier) / 2;
            
            --j;
        }
        
        while (carrier > 0) {
            sb.append(carrier % 2);
            carrier /= 2;
        }
            
        sb.reverse();
        
        return sb.toString();
    }
}
