class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 ||
           num2 == null || num2.length() == 0)
            return "0";
        
        int[] product = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; --j) {
                char c1 = num1.charAt(i);
                char c2 = num2.charAt(j);
                product[i + j + 1] += (c1 - '0') *  (c2 - '0') + carry;
                carry = product[i + j + 1] / 10;
                product[i + j + 1] %= 10;
            }
            
            if (carry > 0)
                product[i] = carry; 
        }
        
        int i = 0;
        while (i < num1.length() + num2.length() && product[i] == 0)
            ++i;

        if (i == num1.length() + num2.length())
            return "0";
        String res = "" + (char)(product[i++] + '0');
        while (i < num1.length() + num2.length())
            res += (char)(product[i++] + '0');
        
        return res;
    }
}

// faster:

class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 ||
           num2 == null || num2.length() == 0)
            return "0";

        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        
        int[] product = new int[n1.length + n2.length];
        for (int i = n1.length - 1; i >= 0; --i) {
            int carry = 0;
            for (int j = n2.length - 1; j >= 0; --j) {
                char c1 = n1[i];
                char c2 = n2[j];
                product[i + j + 1] += (c1 - '0') *  (c2 - '0') + carry;
                carry = product[i + j + 1] / 10;
                product[i + j + 1] %= 10;
            }

            if (carry > 0)
                product[i] = carry;
        }

        int i = 0;
        while (i < n1.length + n2.length && product[i] == 0)
            ++i;

        if (i == n1.length + n2.length)
            return "0";
        String res = "" + (char)(product[i++] + '0');
        while (i < n1.length + n2.length)
            res += (char)(product[i++] + '0');

        return res;     
    }
}
