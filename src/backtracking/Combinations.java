package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n <= 0 || n < k)
            return result;
        List<Integer> item = new ArrayList<Integer>();
        dfs(n, k, 1, item, result); // because it need to begin from 1
        return result;
    }
    private void dfs(int n, int k, int start, List<Integer> item,
                     List<List<Integer>> res) {
        if (item.size() == k) {
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for (int i = start; i <= n; i++) {
            item.add(i);
            dfs(n, k, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}
