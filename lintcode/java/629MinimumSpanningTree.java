/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    String findParent(Map<String, String> map, String city) {
        if (!map.containsKey(city)) {
            return city;
        }

        String parent = findParent(map, map.get(city));
        map.put(city, parent);

        return parent;
    }
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        Map<String, String> map = new HashMap<>();
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection conn1, Connection conn2) {
                if (conn1.cost == conn2.cost) {
                    if (conn1.city1.compareTo(conn2.city1) == 0)
                        return conn1.city2.compareTo(conn2.city2);
                    return conn1.city1.compareTo(conn2.city1);
                }
                return conn1.cost - conn2.cost;
            }
        });

        List<Connection> lst = new ArrayList<>();
        for (Connection conn: connections) {
            String p1 = findParent(map, conn.city1);
            String p2 = findParent(map, conn.city2);

            if (p1.equals(p2))
                continue;

            if (p1.compareTo(p2) < 0) {
                map.put(p1, p2);
            } else {
                map.put(p2, p1);
            }

            lst.add(conn);
        }

        String parent = findParent(map, connections.get(0).city1);
        for (Connection conn: connections) {
            if (!parent.equals(findParent(map, conn.city1)))
                return new ArrayList<>();
        }
        return lst;
    }
}
