class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;
        int max=0;
        int totalSum=0;
        int windowSize = cardPoints.length - k;
        int sum=0;

        for(int s=0; s<cardPoints.length; s++){
            totalSum+=cardPoints[s];
        }
        for(int r=0; r<cardPoints.length; r++){
            sum+=cardPoints[r];

            while(r-left+1>windowSize){
                sum-=cardPoints[left];
                left++;
            }

            if(r-left+1==windowSize){
                max=Math.max(max,totalSum-sum);
            }
        }
        return max;
    }
}