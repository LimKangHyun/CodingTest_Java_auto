import java.util.*;

class Solution {
    static List<Set<Integer>> candidateKeys = new ArrayList<>();
    static String[][] relation;
    static int count = 0;
    public int solution(String[][] _relation) {
        relation = _relation;
        for (int i = 1; i <= relation[0].length; i++) {
            List<Integer> list = new ArrayList<>();
            comb(0, i, list);
        }
        return count;
    }
    private void comb(int start, int size, List<Integer> list) {
        if (list.size() == size) {
            if (checkUnique(list) && checkMinimal(list)) count++;
            return;
        }
        for (int i = start; i < relation[0].length; i++) {
            list.add(i);
            comb(i + 1, size, list);
            list.remove(list.size() - 1);
        }
    }
    private boolean checkUnique(List<Integer> list) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < relation.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int n : list) {
                sb.append(relation[i][n]);
            }
            if (set.contains(sb.toString())) return false;
            set.add(sb.toString());
        }
        return true;
    }
    private boolean checkMinimal(List<Integer> list) {
        Set<Integer> current = new HashSet<>(list);
        for (Set<Integer> key : candidateKeys) {
            if (current.containsAll(key)) return false;
        }
        candidateKeys.add(current);
        return true;
    }
}