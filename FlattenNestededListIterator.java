// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack;
    NestedInteger nextEl;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        this.stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        return this.nextEl.getInteger();
    }

    @Override
    public boolean hasNext() {

        while(!this.stack.isEmpty()) {
            if (!this.stack.peek().hasNext()) {
                this.stack.pop();
            } else if((this.nextEl = stack.peek().next()).isInteger()) {
                return true;
            } else {
                stack.push(this.nextEl.getList().iterator());
            }
        }

        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */