class Solution {
    void IpAddresses(String s, int start, StringBuilder sb, List<String> res, int k, int num) {
        if (start >= s.length()) {
            if (num == k)
                res.add(sb.toString());
            return;
        }
        
        if (num >= k)
            return;
        
        char c = s.charAt(start);
        if (num > 0)
            sb.append(".");
        sb.append(c);
        IpAddresses(s, start + 1, sb, res, k, num + 1);
        if (c != '0' && start + 1 < s.length()) {
            char c2 = s.charAt(start + 1);
            sb.append(c2);
            IpAddresses(s, start + 2, sb, res, k, num + 1);
            int sum = 100 * (c - '0') + 10 * (c2 - '0');
            if (start + 2 < s.length()) {
                char c3 = s.charAt(start + 2);
                sum += c3 - '0';
                if (sum <= 255) {
                    sb.append(c3);
                    IpAddresses(s, start + 3, sb, res, k, num + 1);
                    sb.setLength(sb.length() - 1);
                }
            }
            
            sb.setLength(sb.length() - 1);
        }
        
        sb.setLength(sb.length() - 1);
        if (num > 0)
            sb.setLength(sb.length() - 1);
    }
    
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        IpAddresses(s, 0, sb, res, 4, 0);
        
        return res;
    }
}
