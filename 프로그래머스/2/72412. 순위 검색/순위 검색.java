import java.util.*;

class Solution {
    static Map<String, List<Integer>> map = new HashMap<>();
    public int[] solution(String[] infos, String[] query) {
        int[] answer = new int[query.length];
        for (String info : infos) {
            String[] arr = info.split(" ");
            String[] conditions = Arrays.copyOfRange(arr, 0, 4);
            int score = Integer.parseInt(arr[arr.length - 1]);
            dfs(conditions, score, 0, new StringBuilder());
        }
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }
        for (int i = 0; i < query.length; i++) {
            StringBuilder sb = new StringBuilder();
            String q = query[i].replace(" and", "");
            String[] arr = q.split(" ");
            for (int j = 0; j < 4; j++) {
                sb.append(arr[j]);
            }
            int score = Integer.parseInt(arr[arr.length - 1]);
            if (!map.containsKey(sb.toString())) {
                answer[i] = 0;
                continue;
            }
            List<Integer> list = map.get(sb.toString());
            int idx = lowerBound(list, score);
            answer[i] = list.size() - idx;
        }
        return answer;
    }
    private void dfs(String[] conditions, int score, int depth, StringBuilder sb) {
        if (depth == 4) {
            List<Integer> list = map.get(sb.toString());
            if (list == null) {
                list = new ArrayList<>();
                map.put(sb.toString(), list);
            }
            list.add(score);
            return;
        }
        int len = sb.length();
        sb.append(conditions[depth]);
        dfs(conditions, score, depth + 1, sb);
        sb.setLength(len);
        
        sb.append("-");
        dfs(conditions, score, depth + 1, sb);
        sb.setLength(len);
    }
    private int lowerBound(List<Integer> list, int score) {
        int left = 0;
        int right = list.size();
        while(left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < score) {
                left = mid + 1;
            } else right = mid;
        }
        return left;
    }
}