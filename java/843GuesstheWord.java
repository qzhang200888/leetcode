/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    int similarity(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < array1.length;++i) {
            if (array1[i] == array2[i])
                ++count;
        }

        return count;
    }

    private String getBestCandidate(Set<String> wordlist, int[] count) {
		int max = 0;
		String best = "";
		for (String s : wordlist) {
			int c = 0;
			for (char a : s.toCharArray()) {
				c += count[a - 'a'];
			}
			if (c > max) {
				max = c;
				best = s;
			}
		}
		return best;
	}
    
    public void findSecretWord(String[] wordlist, Master master) {
		int[] count = new int[26];
		for (String s : wordlist) {
			for (char c : s.toCharArray()) {
				count[c - 'a']++;
			}
		}
        
        Set<String> set = new HashSet<String>(Arrays.asList(wordlist));
        int i = 0;
        while (i++ < 10) {
            String word = getBestCandidate(set, count);

            int match = master.guess(word);

            if (match == 6)
                return;
            
            List<String> lst = new ArrayList<>();
            for (String w: set) {
                if (similarity(word, w) != match)
                    lst.add(w);
            }
                
            for (String s: lst)
                set.remove(s);
        }
    }
}
