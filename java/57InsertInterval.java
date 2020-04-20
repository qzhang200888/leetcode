/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || newInterval == null)
            return res;
        
        boolean added = false;
        for (Interval i: intervals) {
            if (added || newInterval.start > i.end)
                res.add(i);
            else if (newInterval.end < i.start && !added) {
                res.add(newInterval);
                res.add(i);
                added = true;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        
        if (!added)
            res.add(newInterval);
        
        return res;
    }
}

=============================================================================

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lst = new ArrayList<>();
        boolean added = false;
        for (int[] inter: intervals) {
            if (inter[1] < newInterval[0])
                lst.add(inter);
            else if (inter[0] > newInterval[1]) {
                if (!added) {
                    lst.add(newInterval);
                    added = true;
                }
                
                lst.add(inter);
            } else {
                newInterval[0] = Math.min(newInterval[0], inter[0]);
                newInterval[1] = Math.max(newInterval[1], inter[1]);
            }
        }
        
        if (!added)
            lst.add(newInterval);
        
        int[][] res = new int[lst.size()][2];
        for (int i = 0; i < lst.size(); ++i) {
            res[i][0] = lst.get(i)[0];
            res[i][1] = lst.get(i)[1];
        }
        
        return res;
    }
}
