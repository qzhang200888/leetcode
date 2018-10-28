import java.util.*;

class SlidingWindowMaxDiff {

	public static void main(String[] args) {
		SlidingWindowMaxDiff swm = new SlidingWindowMaxDiff();
	
		System.out.println(swm.fTreeMap(new int[] {3, 2, 6, -1, 7, 5, 10, 11, -2, 4, -8}, 4));
		System.out.println(swm.fQueue(new int[] {3, 2, 6, -1, 7, 5, 10, 11, -2, 4, -8}, 4));
	}
	
	public List<Integer> fTreeMap(int[] ar, int k) {
		List<Integer> lst = new ArrayList<>();
		TreeMap<Integer, Integer> t = new TreeMap<>();
		
		int i = 0;
		for (; i < k; ++i) {
			int fre = t.getOrDefault(ar[i], 0);
			t.put(ar[i], fre + 1);
		}
		
		int firstKey = t.firstKey();
		int lastKey = t.lastKey();
		lst.add(lastKey - firstKey);
		for (; i < ar.length; ++i) {
			int fre = t.getOrDefault(ar[i], 0);
			t.put(ar[i], fre + 1);
			
			fre = t.get(ar[i - k]);
			if (fre == 1)
				t.remove(ar[i - k]);
			else t.put(ar[i], fre - 1);
			
			firstKey = t.firstKey();
			lastKey = t.lastKey();
			lst.add(lastKey - firstKey);
		}
		
		return lst;
	}
	
	public List<Integer> fQueue(int[] ar, int k) {
		List<Integer> lst = new ArrayList<>();
		Deque<Integer> minQueue = new LinkedList<>();
		Deque<Integer> maxQueue = new LinkedList<>();
				
		int i = 0;
		for (; i < k; ++i) {
			while (!minQueue.isEmpty() && ar[minQueue.peekLast()] > ar[i])
				minQueue.pollLast();
				
			minQueue.offerLast(i);
			
			while (!maxQueue.isEmpty() && ar[maxQueue.peekLast()] < ar[i])
				maxQueue.pollLast();
				
			maxQueue.offerLast(i);
		}
		
		lst.add(ar[maxQueue.peekFirst()] - ar[minQueue.peekFirst()]);
		for (; i < ar.length; ++i) {
			while (!minQueue.isEmpty() && ar[minQueue.peekLast()] > ar[i])
				minQueue.pollLast();
				
			minQueue.offerLast(i);
			
			while (!maxQueue.isEmpty() && ar[maxQueue.peekLast()] < ar[i])
				maxQueue.pollLast();
				
			maxQueue.offerLast(i);
			
			while (i - k >= minQueue.peekFirst())
				minQueue.pollFirst();
				
			while (i - k >= maxQueue.peekFirst())
				maxQueue.pollFirst();
				
			lst.add(ar[maxQueue.peekFirst()] - ar[minQueue.peekFirst()]);	
		}
		
		return lst;
	}
}
