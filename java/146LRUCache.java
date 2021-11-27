class Node {
    public int key;
    public int val;
    public Node prev;
    public Node next;
    
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int capacity;
    int count;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node n = map.get(key);
        removeNode(n);
        addNode(n);
        
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = null;
        if (!map.containsKey(key)) {
            n = new Node(key, value);
            map.put(key, n);
            ++count;
        } else {
            n = map.get(key);
            n.val = value;
            removeNode(n);
        }
        
        addNode(n);
        if (count > capacity) {
            int k = tail.prev.key;
            removeNode(tail.prev);
            map.remove(k);
            --count;
        }
    }
    
    void addNode(Node n) {
        n.next = head.next;
        n.next.prev = n;
        head.next = n;
        n.prev = head;
    }
    
    void removeNode(Node n) {
        Node next = n.next;
        Node prev = n.prev;
        next.prev = prev;
        prev.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

=============================================

class LRUCache {

    class Node {
        public int key;
        public int val;
        public Node prev, next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            prev = next = null;
        }
    }
    
    Node begin, end;
    int capacity;
    int count;
    Map<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        begin = new Node(0, 0);
        end = new Node(0, 0);
        
        begin.next = end;
        end.prev = begin;
        
        map = new HashMap<>();
        count = 0;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            Node prev = n.prev;
            Node next = n.next;
            
            prev.next = next;
            next.prev = prev;
            
            n.next = begin.next;
            n.next.prev = n;
            
            begin.next = n;
            n.prev = begin;
            
            return n.val;
        }
        
        return -1;
    }
    
    public void put(int key, int value) {
        Node n = null;
        if (map.containsKey(key)) {
            n = map.get(key);
            Node prev = n.prev;
            Node next = n.next;
            
            prev.next = next;
            next.prev = prev;
            
            n.val = value;
        } else {
            ++count;
            
            if (count > capacity) {
                count = capacity;
            
                Node oldest = end.prev;
                Node newLast = oldest.prev;
            
                newLast.next = end;
                end.prev = newLast;
            
                map.remove(oldest.key);
            }
            
            n = new Node(key, value);
            map.put(key, n);
        }
 
        n.next = begin.next;
        n.next.prev = n;
            
        begin.next = n;
        n.prev = begin;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
