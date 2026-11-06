import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // Sort logs by request time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // Store query time and original index
        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        // Sort queries by time
        Arrays.sort(sortedQueries,
            (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];

        // Frequency of requests for each server
        int[] freq = new int[n + 1];

        int left = 0;
        int right = 0;
        int active = 0;

        for (int i = 0; i < queries.length; i++) {

            int end = sortedQueries[i][0];
            int start = end - x;

            // Add logs inside the right boundary
            while (right < logs.length && logs[right][1] <= end) {

                int server = logs[right][0];

                if (freq[server] == 0) {
                    active++;
                }

                freq[server]++;
                right++;
            }

            // Remove logs outside the left boundary
            while (left < right && logs[left][1] < start) {

                int server = logs[left][0];

                freq[server]--;

                if (freq[server] == 0) {
                    active--;
                }

                left++;
            }

            // Restore answer to original query position
            ans[sortedQueries[i][1]] = n - active;
        }

        return ans;
    }
}