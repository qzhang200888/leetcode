/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        Collections.reverse(nestedList);
        for (NestedInteger ni: nestedList)
            stack.push(ni);
    }

    @Override
    public Integer next() {
        while (true) {
            NestedInteger ni = stack.pop();
            if (ni.isInteger())
                return ni.getInteger();
            List<NestedInteger> nestedList = ni.getList();
            Collections.reverse(nestedList);
            for (NestedInteger nint: nestedList)
                stack.push(nint);
        }
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger ni = stack.peek();
            if (ni.isInteger())
                return true;
            stack.pop();
            List<NestedInteger> nestedList = ni.getList();
            Collections.reverse(nestedList);
            for (NestedInteger nint: nestedList)
                stack.push(nint);
        }
        
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
