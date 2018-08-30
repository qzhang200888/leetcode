class Solution {
    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;       
    }
    
    public int kSimilarity(String A, String B) {
        if (A.equals(B))
            return 0;
        
        char[] target = B.toCharArray();
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(A);
        int step = 1;    
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                
                int j = 0;
                while (chars[j] == target[j])
                    ++j;
                
                int k = j + 1;
                boolean found = false;
                List<Integer> candidates = new ArrayList<>();
                while (k < s.length()) {
                    if (chars[j] == target[k] && chars[k] == target[j]) {
                        found = true;
                        
                        swap(chars, j, k);
                        String neighbor = new String(chars);
                        swap(chars, j, k);
                        
                        if (neighbor.equals(B))
                            return step;

                        if (visited.add(neighbor)) {
                            queue.offer(neighbor);
                        }
                        
                        break;
                    } else if (chars[k] != target[k] && chars[k] == target[j])
                        candidates.add(k);
                    
                    ++k;
                }
                
                if (found)
                    continue;
                
                for (int l: candidates) {
                    swap(chars, j, l);
                    String neighbor = new String(chars);
                    swap(chars, j, l);

                    if (visited.add(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
            
            ++step;
        }
        
        return 0;
    }
}

// faster

class Solution {
    void swap(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;       
    }
    
    public int kSimilarity(String A, String B) {
        if (A.equals(B))
            return 0;

        char[] start = A.toCharArray();
        char[] target = B.toCharArray();

        int step = 0; 
        for (int i = 0; i < start.length - 1; ++i) {
            if (start[i] == target[i])
                continue;
            for (int j = i + 1; j < start.length; ++j) {
                if (start[i] == target[j] && start[j] == target[i]) {
                    swap(start, i, j);
                    ++step;
                    break;
                }
            }
        }
        
        A = new String(start);
        if (A.equals(B))
            return step;
        
        ++step;
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(A);   
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                
                int j = 0;
                while (chars[j] == target[j])
                    ++j;
                
                int k = j + 1;
                while (k < s.length()) {
                    if (chars[k] != target[k] && chars[k] == target[j]) {                      
                        swap(chars, j, k);
                        String neighbor = new String(chars);
                        swap(chars, j, k);
                        
                        if (neighbor.equals(B))
                            return step;

                        if (visited.add(neighbor)) {
                            queue.offer(neighbor);
                        }
                    }
                    
                    ++k;
                }
            }
            
            ++step;
        }
        
        return 0;
    }
}
