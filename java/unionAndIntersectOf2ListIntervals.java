import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class Interval {
        public int start;
        public int end;
        
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT 
        1st set: [0, 2], [5, 10], [16, 20]
        2nd set: [1, 5], [10, 18], [20, 23]

        AND Result: [1, 2], [5, 5], [10, 10], [16, 18], [20, 20]

        */
        
        Solution s = new Solution();
        s.run();
    }
    
    public void run() {
        Interval[] first = new Interval[] {
            //new Interval(0, 2), 
            new Interval(0, 2), new Interval(5, 10),
            new Interval(16, 20)
        };
        
        Interval[] second = new Interval[] {
            //new Interval(20, 23)
            new Interval(1, 5), new Interval(10, 14),
            new Interval(20, 23)
        };
        
        List<Interval> res = union(Arrays.asList(first), Arrays.asList(second));
        
        System.out.println();
        for (Interval interval: res) {
            System.out.print("(" + interval.start + "," + interval.end + "),");
        }        
    }
    
    public List<Interval> intersect(List<Interval> fList, List<Interval> sList) {
        List<Interval> res = new ArrayList<>();
        
        int i = 0, j = 0;
        while (i < fList.size() && j < sList.size()) {
            Interval i1 = fList.get(i);
            Interval i2 = sList.get(j);
            
            if (i1.start > i2.end) {
                ++j;
                continue;
            }
            
            if (i2.start > i1.end) {
                ++i;
                continue;
            }
            
            int newStart = Math.max(i1.start, i2.start);
            int newEnd = Math.min(i1.end, i2.end);
            
            res.add(new Interval(newStart, newEnd));
            
            if (i1.end > i2.end)
                ++j;
            else
                ++i;
        }
        
        return res;
    }
    
    public List<Interval> union(List<Interval> fList, List<Interval> sList) {
        List<Interval> res = new ArrayList<>();
        
        int i = 0, j = 0;
        Interval temp = null;
        while (i < fList.size() && j < sList.size()) {
            Interval i1 = fList.get(i);
            Interval i2 = sList.get(j);
            
            if (temp == null) {
                if (i1.start > i2.end) {
                    temp = i2;
                    ++j;
                    continue;
                } else if (i2.start > i1.end) {
                    temp = i1;
                    ++i;
                    continue;
                }
                
                temp = new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
            } else {
                if (temp.end < i1.start && temp.end < i2.start) {
                    res.add(temp);
                    temp = null;
                    continue;
                } else if (temp.end >= i1.start) {
                    temp.start = Math.min(temp.start, i1.start);
                    temp.end = Math.max(temp.end, i1.end);
                    ++i;
                } else if (temp.end >= i2.start){
                    temp.start = Math.min(temp.start, i2.start);
                    temp.end = Math.max(temp.end, i2.end);
                    ++j;                   
                }
            }
        }
        
        while (i < fList.size()) {
            Interval interval = fList.get(i);
            if (temp == null) {
                res.add(interval);
                ++i;
                continue;
            }
            
            if (temp.end < interval.start) {
                res.add(temp);
                temp = null;
                continue;
            }
            
            temp.start = Math.min(temp.start, interval.start);
            temp.end = Math.max(temp.end, interval.end);
            ++i;
        }
        
        
        while (j < sList.size()) {
            Interval interval = sList.get(j);
            if (temp == null) {
                res.add(interval);
                ++j;
                continue;
            }
            
            if (temp.end < interval.start) {
                res.add(temp);
                temp = null;
                continue;
            }
            
            temp.start = Math.min(temp.start, interval.start);
            temp.end = Math.max(temp.end, interval.end);
            ++j;
        }
        
        if (temp != null)
            res.add(temp);
            
        return res;
    }
}
