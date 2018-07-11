class Solution {
    String[] nums = {"One", "Two", "Three", "Four", "Five", 
                   "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                   "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty",
                  "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        String res = "";
        int r = num % 100;
        if (r < 10 && r > 0)
            res = nums[r - 1];
        else if (r >= 10 && r < 20)
            res = teens[r - 10];
        else if (r >= 20) {
            res = tens[r / 10 - 2];
            if (r % 10 != 0)
                res += " " + nums[r % 10 - 1];
        }
        
        if (((num / 100) % 10) != 0) {
            if (!res.equals(""))
                res = nums[(num / 100) % 10 - 1] + " Hundred " + res;
            else res = nums[(num / 100) % 10 - 1] + " Hundred";
        }
        
        num /= 1000;
        if (num == 0)
            return res;
        
        String thousands = numberToWords(num % 1000);
        if (!thousands.equals("Zero") && !res.equals(""))
            res = thousands + " Thousand " + res;
        else if (!thousands.equals("Zero"))
            res = thousands + " Thousand";
        
        num /= 1000;
        if (num == 0)
            return res;
        
        String millions = numberToWords(num % 1000);
        if (!millions.equals("Zero") && !res.equals(""))
            res = millions + " Million " + res;
        else if (!millions.equals("Zero"))
            res = millions + " Million";
        
        num /= 1000;
        if (num == 0)
            return res;
        
        String billions = numberToWords(num % 1000);
        if (!billions.equals("Zero") && !res.equals(""))
            res = billions + " Billion " + res;
        else if (!billions.equals("Zero"))
            res = billions + " Billion";
        
        return res;
    }
}
