class Solution {
    void transverse(String email, Map<String, List<String>> graph, Set<String> visited, List<String> emails) {
        if (visited.contains(email))
            return;
        
        visited.add(email);
        emails.add(email);
        
        List<String> neighbors = graph.get(email);
        if (neighbors == null)
            return;
        
        for (String em: neighbors)
            transverse(em, graph, visited, emails);
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> names = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        
        for (List<String> lst: accounts) {
            String name = lst.get(0);
            for (int i = 1; i < lst.size(); ++i) {
                String email = lst.get(i);
                names.put(email, name);
                for (int j = i + 1; j < lst.size(); ++j) {
                    String email2 = lst.get(j);
                    
                    List<String> emailList = graph.getOrDefault(email, new ArrayList<>());
                    emailList.add(email2);
                    graph.put(email, emailList);
                    
                    List<String> emailList2 = graph.getOrDefault(email2, new ArrayList<>());
                    emailList2.add(email);
                    graph.put(email2, emailList2);
                }
            }
        }
        
        Set<String> visited = new HashSet<String>();
        
        List<List<String>> res = new ArrayList<>();
        for (String email: names.keySet()) {
            if (visited.contains(email))
                continue;
            List<String> emails = new ArrayList<String>();
            transverse(email, graph, visited, emails);
            
            Collections.sort(emails);
            emails.add(0, names.get(email));
            res.add(emails);
        }
        
        return res;
    }
}
