class Solution {
    public String toGoatLatin(String S) {
        if (S == null)
            return null;
        
        String[] strs = S.split("\\s");
        String apend = "a";
        for (int i = 0; i < strs.length; ++i) {
            char c = strs[i].substring(0,1).toLowerCase().charAt(0);
            if (c != 'a' && c != 'e' && c != 'i' & c != 'o' && c != 'u') {
                strs[i] = strs[i].substring(1) + strs[i].substring(0,1);
            }
            
            strs[i] += "ma" + apend;
            apend += "a";
        }
        
        return String.join(" ", strs);
    }
}
