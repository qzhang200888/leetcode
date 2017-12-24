class MyCalendar {
    vector<pair<int, int>> events;
public:
    MyCalendar() {
        
    }
    
    bool book(int start, int end) {
        int i = 0;
        for (; i < events.size(); ++i) {
            if (start < events[i].second) {
                if (end > events[i].first)
                    return false;
                events.insert(events.begin() + i, make_pair(start, end));
                break;
            }
        }
        
        if (i >= events.size())
            events.push_back(make_pair(start, end));
        
        return true;
    }
};
