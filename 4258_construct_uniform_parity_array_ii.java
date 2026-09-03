class Solution {
    public boolean uniformArray(int[] nums1) {
       int minOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int num : nums1) {
            if (num % 2 == 1) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // No odd numbers → all numbers are already even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // An even number smaller than the smallest odd
        // cannot be converted into a positive odd number
        for (int num : nums1) {
            if (num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
}
}