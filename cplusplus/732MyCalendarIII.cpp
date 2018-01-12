class MyCalendarThree {
    map<int, int> dict;
    
public:
    MyCalendarThree() {
     
    }
    
    int book(int start, int end) {
        dict[start]++;
        dict[end]--;
        
        int count = 0, max = 0;
        for (map<int, int>::iterator it = dict.begin(); it != dict.end(); ++it) {
            count += it->second; 
            
            if (count > max)
                max = count;
        }
        
        return max;
    }
};
