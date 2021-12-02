class Solution {
    class Log {
        public String identifier;
        public String content;
        public boolean isDigit;
        public String wholeString;
        public int originalPos;
        
        public Log(String s, int pos) {
            wholeString = s;
            originalPos = pos;
            int i = 0;
            while (i < s.length() && s.charAt(i) != ' ')
                ++i;
            identifier = s.substring(0, i).trim();
            content = s.substring(i).trim();
            
            while (i < s.length() && s.charAt(i) == ' ') {
                ++i;
            }
            
            char c = s.charAt(i) ;
            if (c>='0' && c <= '9')
                isDigit = true;
            else isDigit = false;
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        List<Log> logList = new ArrayList<>();
        for (int i = 0; i < logs.length; ++i) {
            logList.add(new Log(logs[i], i));
        }
        Collections.sort(logList, new Comparator<Log>() {
            @Override
            public int compare(Log l1, Log l2) {
                if (!l1.isDigit && l2.isDigit)
                    return -1;
                if (!l2.isDigit && l1.isDigit)
                    return 1;
                if (l1.isDigit)
                    return l1.originalPos - l2.originalPos;
                int ret = l1.content.compareTo(l2.content);
                if (ret != 0)
                    return ret;
                return l1.identifier.compareTo(l2.identifier);
            }
        });
        
        String[] res = new String[logs.length];
        for (int i = 0; i < logs.length; ++i) {
            res[i] = logList.get(i).wholeString;
        }

        return res;
    }
}
