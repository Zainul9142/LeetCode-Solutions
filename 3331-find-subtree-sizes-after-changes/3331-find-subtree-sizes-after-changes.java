
import java.util.*;

class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        List<List<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            tree.get(parent[i]).add(i);
        }

        int[] ans = new int[n];
        int[] last = new int[26];

        Arrays.fill(last, -1);

        dfs(0, -1, tree, s, last, ans);

        return ans;
    }

    private void dfs(int node, int par,
                     List<List<Integer>> tree,
                     String s, int[] last, int[] ans) {

        int idx = s.charAt(node) - 'a';
        int previous = last[idx];

        last[idx] = node;
        ans[node] = 1;

        for (int child : tree.get(node)) {
            dfs(child, node, tree, s, last, ans);
        }

        int newParent = (previous != -1) ? previous : par;

        if (newParent != -1) {
            ans[newParent] += ans[node];
        }

        last[idx] = previous;
    }
}
