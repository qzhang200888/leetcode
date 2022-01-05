
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> lst = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });
        
        List<int[]> res = new ArrayList<>();
        int[] interv = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i][0] > interv[1]) {
                res.add(interv);
                interv = intervals[i];
            } else {
                interv[1] = Math.max(interv[1], intervals[i][1]);
            }
        }
        
        res.add(interv);
        
        int[][] output = new int[res.size()][2];
        for (int i = 0; i < output.length; ++i) {
            output[i][0] = res.get(i)[0];
            output[i][1] = res.get(i)[1];
        }

        return output;
    }
}

============================================================================
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
