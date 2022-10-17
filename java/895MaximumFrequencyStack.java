class FreqStack {
    Map<Integer, Integer> freMap;
    Map<Integer, Stack<Integer>> stackMap;
    int max;
    public FreqStack() {
        freMap = new HashMap<>();
        stackMap = new HashMap<>();
        max = 0;
    }
    
    public void push(int val) {
        int frequency = freMap.getOrDefault(val, 0) + 1;
        max = Math.max(max, frequency);

        if (!stackMap.containsKey(frequency)) {
            stackMap.put(frequency, new Stack<>());
        }

        freMap.put(val, frequency);
        stackMap.get(frequency).push(val);
    }
    
    public int pop() {
        int res = stackMap.get(max).pop();
        freMap.put(res, freMap.get(res) - 1);
        if (stackMap.get(max).size() == 0) {
            --max;
        }

        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
