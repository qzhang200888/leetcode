class Solution {
    class Node {
        public char val;
        public Node next;
        
        public Node(char val) {
            this.val = val;
            this.next = null;
        }
        public Node(char val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    
    void fractionToDecimal(long numerator, long denominator, StringBuilder sb) {
        Node head = new Node('0', null);
        Node cur = head;
        
        Map<Long, Node> map = new HashMap<>();
        
        while (numerator != 0) {
            numerator *= 10;
            if (map.containsKey(numerator)) {
                Node start = map.get(numerator);
                Node n = head.next;
                
                while (n != null && n != start) {
                    sb.append(n.val);
                    n = n.next;
                }
                
                if (n == null)
                    return;
                sb.append('(');
                
                while (n != null) {
                    sb.append(n.val);
                    n = n.next;
                }
                
                sb.append(')');
                
                return;
            }
            
            long div = numerator / denominator;
            cur.next = new Node((char)('0' + div));
            map.put(numerator, cur.next);
            numerator %= denominator;
            cur = cur.next;
        }
        
        Node n = head.next;
        while (n != null) {
            sb.append(n.val);
            n = n.next;
        }        
    }
    
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        int sign = 1;
        long num = numerator;
        long denom = denominator;
        
        if (numerator < 0) {
            sign *= -1;
            num = -num;
        }
        
        if (denominator < 0) {
            sign *= -1;
            denom = -denom;
        }
                
        StringBuilder sb = new StringBuilder();
        if (sign < 0)
            sb.append('-');
        sb.append(num / denom);

        long fraction = num % denom;
        if (fraction > 0) {
            sb.append('.');
            fractionToDecimal(fraction, denom, sb); 
        }

        return sb.toString();
    }
}

==================================================================

class Solution {
 
    void fractionToDecimal(long numerator, long denominator, StringBuilder sb) {
        Map<Long, Integer> map = new HashMap<>();
        
        int pos = sb.length();
        while (numerator != 0) {
            numerator *= 10;
            if (map.containsKey(numerator)) {
                sb.insert(map.get(numerator), "(" );
                sb.append(')');
                
                return;
            }
            
            long div = numerator / denominator;
            sb.append((char)('0' + div));
            map.put(numerator, pos);
            numerator %= denominator;
            
            ++pos;
        }      
    }
    
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";

        int sign = 1;
        long num = numerator;
        long denom = denominator;
        
        if (numerator < 0) {
            sign *= -1;
            num = -num;
        }
        
        if (denominator < 0) {
            sign *= -1;
            denom = -denom;
        }
                
        StringBuilder sb = new StringBuilder();
        if (sign < 0)
            sb.append('-');
        sb.append(num / denom);

        long fraction = num % denom;
        if (fraction > 0) {
            sb.append('.');
            fractionToDecimal(fraction, denom, sb); 
        }

        return sb.toString();
    }
}
