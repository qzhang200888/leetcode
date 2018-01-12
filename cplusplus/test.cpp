#include <iostream>
#include <map>
#include <sstream>

using namespace std;

class MyCalendarThree {
    map<int, int> dict;
    
public:
    MyCalendarThree() {
        
    }
  
    int book(int start, int end) {
        dict[start]++;
        dict[end]--;
        
        int count = 0, max = 0;
        for (auto &d: dict) {
            count += d.second;
            cout << d.first << "," << d.second << endl;

            if (count > max)
                max = count;
        }
       
        return max;
    }
};

int main() {
    MyCalendarThree obj;

    obj.book(10,20);
    obj.book(50,60);
    obj.book(10,40);

cout << "****************" << endl;

    std::cout << obj.book(5,15) << std::endl;

    return 0;
}
