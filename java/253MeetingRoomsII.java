/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    class Event {
        public int time;
        public int val;
        public Event(int time, int val) {
            this.time = time;
            this.val = val;
        }
    }
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return 0;
            
        List<Event> events = new ArrayList<>();
        for (Interval meeting: intervals) {
            events.add(new Event(meeting.start, 1));
            events.add(new Event(meeting.end, -1));
        }
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2) {
                return e1.time - e2.time;
            }
        });
        
        int count = 0, max = 0;
        int prevTime = -1;
        
        for (Event e: events) {
            if (e.time != prevTime) {
                prevTime = e.time;
                if (count > max)
                    max = count;
            }
            
            count += e.val;
        }
        
        if (count > max)
            max = count;
            
        return max;
    }
}
