import java.util.*;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < deck.length; i++) {
            q.add(i);
        }

        int[] result = new int[deck.length];

        int i = 0;

        while (!q.isEmpty()) {

            int curr = q.poll();

            result[curr] = deck[i];
            i++;

            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }

        return result;
    }
}