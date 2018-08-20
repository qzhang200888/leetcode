class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return new int[] {1};
        int carrier = 1;
        int i = digits.length - 1;
        while (i >= 0) {
            int val = digits[i];
            digits[i] = (val + carrier) % 10;
            carrier = (val + carrier) / 10;
            --i;
        }
        
        if (carrier == 0)
            return digits;
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = carrier;
        for (i = 0; i < digits.length; ++i) {
            newDigits[i + 1] = digits[i];
        }
        
        return newDigits;
    }
}
