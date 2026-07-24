class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        right = nsr(heights, right);
        left = nsl(heights, left);
        for (int i = 0; i < heights.length; i++) {
            int length = heights[i];
            int breadth = right[i] - left[i] - 1;
            area = Math.max(area, length * breadth);
        }
        return area;
    }

    private int[] nsr(int[] heights, int[] right) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            right[i] = (st.isEmpty() ? n : st.peek());
            st.push(i);
        }
        return right;
    }

    private int[] nsl(int[] heights, int[] left) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            left[i] = (st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        return left;
    }
}