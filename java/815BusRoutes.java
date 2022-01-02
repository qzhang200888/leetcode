
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int bs: routes[i]) {
                if (!map.containsKey(bs))
                    map.put(bs, new ArrayList<>());
                map.get(bs).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(source);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int stop = queue.poll();
                if (stop == target)
                    return step;
                for (int r: map.get(stop)) {
                    if (visited.contains(r))
                        continue;
                    visited.add(r);
                    for (int busStop: routes[r]) {
                        queue.add(busStop);
                    }
                }
            }
            ++step;
        }
        
        return -1;
    }
}

===================================================================================

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; ++i) {
            for (int bs: routes[i]) {
                if (!map.containsKey(bs))
                    map.put(bs, new ArrayList<>());
                map.get(bs).add(i);
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedRoutes = new HashSet<>();
        queue.add(source);
        visitedStops.add(source);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int stop = queue.poll();
                if (stop == target)
                    return step;
                for (int r: map.get(stop)) {
                    if (visitedRoutes.contains(r))
                        continue;
                    visitedRoutes.add(r);
                    for (int busStop: routes[r]) {
                        if (visitedStops.contains(busStop))
                            continue;
                        queue.add(busStop);
                        visitedStops.add(busStop);
                    }
                }
            }
            ++step;
        }
        
        return -1;
    }
}
