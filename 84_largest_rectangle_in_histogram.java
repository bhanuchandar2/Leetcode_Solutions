class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        Stack<Integer> st =new Stack<>();
        for(int i=0; i<heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()]>heights[i]){
                int element = st.pop();
                int nse=i;
                int pse=st.isEmpty()?-1:st.peek();
                maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int element=st.pop();
            int nse=heights.length;
            int pse=st.isEmpty()?-1:st.peek();
            maxArea=Math.max(heights[element]*(nse-pse-1),maxArea);
        }
        return maxArea;
    }
}