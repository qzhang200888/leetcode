/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    int offset = 0;
    int read = 0;
    char[] buf4 = new char[4];
    
    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (offset < read) {
            buf[i++] = buf4[offset++];
            --n;
        }
        
        while (n > 0) {
            read = read4(buf4);
            
            int actual = Math.min(n, read);
            for (offset = 0; offset < actual; ++offset)
                buf[i++] = buf4[offset];
                
            if (actual < 4) {
                break;
            }
            
            n -= actual;
        }
        
        return i;
    }
}
