class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int result[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){
            while(!s.isEmpty() && temperatures[i] > temperatures[s.peek()]){
                int index=s.pop();
                result[index]=i-index;
            }

            s.push(i);
        }

        while(!s.isEmpty()){
            result[s.pop()]=0;
        }
        return result;
    }
}