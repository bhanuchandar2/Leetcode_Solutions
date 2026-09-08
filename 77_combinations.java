class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        backtrack(1, result, list, n, k);

        return result;
    }

    public void backtrack(
        int start,
        List<List<Integer>> result,
        List<Integer> list,
        int n,
        int k
    ) {

        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {

            list.add(i);
            backtrack(i + 1, result, list, n, k); 
            list.remove(list.size() - 1);
        }
    }
}