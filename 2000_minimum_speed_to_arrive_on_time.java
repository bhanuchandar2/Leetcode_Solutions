class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        int start = 1;
        int end = 10000000;

        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            double time = 0;

            // All distances except the last one
            for (int i = 0; i < dist.length - 1; i++) {
                time += Math.ceil((double) dist[i] / mid);
            }

            // Last distance
            time += (double) dist[dist.length - 1] / mid;

            if (time <= hour) {
                ans = mid;
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}