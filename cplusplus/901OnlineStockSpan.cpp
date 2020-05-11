class StockSpanner {
    vector<int> prices;
    vector<int> spans;
public:
    StockSpanner() {
        
    }
    
    int next(int price) {
        prices.push_back(price);
        
        int span = 1;
        int i = prices.size() - 1;
        int cur_span = 1;
        i -= cur_span;
        while (i >= 0 && prices.at(i) <= price) {
            cur_span = spans.at(i);
            span += cur_span;
            i -= cur_span;
        }
        
        spans.push_back(span);
        
        return span;
    }
};

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */
