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
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return res;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        Interval interval = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            if (interval.end < intervals.get(i).start) {
                res.add(interval);
                interval = intervals.get(i);
            } else {
                interval.end = Math.max(intervals.get(i).end, interval.end);
            }
        }
        
        res.add(interval);
        
        return res;
    }
}
