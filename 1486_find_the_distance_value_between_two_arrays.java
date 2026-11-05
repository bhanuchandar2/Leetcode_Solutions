class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        Arrays.sort(arr2);

        int count = 0;

        for (int i = 0; i < arr1.length; i++) {

            int num = arr1[i];

            int left = 0;
            int right = arr2.length - 1;
            boolean found = false;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (arr2[mid] >= num - d && arr2[mid] <= num + d) {
                    found = true;
                    break;
                }
                else if (arr2[mid] < num - d) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }

            if (!found) {
                count++;
            }
        }

        return count;
    }
}