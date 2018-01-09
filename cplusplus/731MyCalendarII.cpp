class MyCalendarTwo {
    vector<pair<int, int>> events;    
public:
    MyCalendarTwo() {
        
    }
    
    bool book(int start, int end) {
        int i = 0;
        for (; i < events.size(); ++i) {
            if (start < events[i].second) {
                if (end > events[i].first) {
                    if ((i + 1) <  events.size() && events[i+1].first < end && events[i+1].first < events[i].second)
                        return false;
                    if (start > events[i].first || (start == events[i].first && end > events[i].second))
                        events.insert(events.begin() + i + 1, make_pair(start, end));
                    else events.insert(events.begin() + i, make_pair(start, end));
                } else {
                    if (start > events[i].first || (start == events[i].first && end > events[i].second))
                        events.insert(events.begin() + i + 1, make_pair(start, end));
                    else events.insert(events.begin() + i, make_pair(start, end));
                }
                break;
            }
        }

        if (i >= events.size())
            events.push_back(make_pair(start, end));

        return true;        
    }
};
