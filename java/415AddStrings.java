class Solution {
    public String addStrings(String num1, String num2) {
        int carrier = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int sum = carrier;
            sum += num1.charAt(i) - '0';
            sum += num2.charAt(j) - '0';
            
            carrier = sum / 10;
            sb.append(sum % 10);
            
            --i;
            --j;
        }

        while (i >= 0) {
            int sum = carrier;
            sum += num1.charAt(i) - '0';
            
            carrier = sum / 10;
            sb.append(sum % 10);
            
            --i;
        }
        
        while (j >= 0) {
            int sum = carrier;
            sum += num2.charAt(j) - '0';
            
            carrier = sum / 10;
            sb.append(sum % 10);

            --j;
        }
        
        while (carrier > 0) {
            sb.append(carrier % 10);
            carrier /= 10;
        }
        return sb.reverse().toString();
    }
}
