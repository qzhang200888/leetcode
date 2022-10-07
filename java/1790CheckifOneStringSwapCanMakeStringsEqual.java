class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        char c1 = '\0', c2 = '\0';
        boolean swapped = false;

        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            if (swapped) {
                return false;
            }

            if (c1 == '\0') {
                c1 = s1.charAt(i);
                c2 = s2.charAt(i);
            } else if (c1 == s2.charAt(i) && c2 == s1.charAt(i)) {
                swapped = true;
            } else {
                return false;
            }
        }

        if (c1 == '\0' || swapped)
            return true;
        return false;
    }
}
