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
