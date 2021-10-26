
class Solution {
    public int lastRemaining(int n) {
        int first = 1;
        boolean forward = true;
        int diff = 1;
        while (n > 1) {
            if (forward || (!forward && n % 2 != 0)) {
                first += diff;
            }
            n /= 2;
            diff *= 2;
            forward = !forward;
        }
        
        return first;
    }
}

===================================================

class Solution {
    public int lastRemaining(int n) {
        int last = n;
        boolean forward = true;
        int diff = 1;
        while (n > 1) {
            if (!forward || (forward && n % 2 != 0)) {
                last -= diff;
            }
            n /= 2;
            diff *= 2;
            forward = !forward;
        }
        
        return last;
    }
}
