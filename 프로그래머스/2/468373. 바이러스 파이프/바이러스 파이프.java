import java.util.*;

class Pipe {
    int to;
    int type;
    Pipe(int to, int type) {
        this.to = to;
        this.type = type;
    }
}

class Solution {
    List<List<Pipe>> tree = new ArrayList<>();
    int answer = 0;
    int n, infection, k;
    int[] orders;
    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        this.infection = infection;
        this.k = k;
        orders = new int[k];
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int pipe = edges[i][2];
            tree.get(u).add(new Pipe (v, pipe));
            tree.get(v).add(new Pipe (u, pipe));
        }
        comb(0, -1);
        return answer;
    }
    private void comb(int depth, int prev) {
        if (depth == k) {
            answer = Math.max(answer, simul());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (i == prev) continue;
            orders[depth] = i;
            comb(depth + 1, i);
        }
    }
    private int simul() {
        Set<Integer> infected = new HashSet<>();
        infected.add(infection);
        for (int i = 0; i < k; i++) {
            infect(orders[i], infected);
        }
        return infected.size();
    }
    private void infect(int type, Set<Integer> infected) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 1];
        for (int node : infected) {
            queue.offer(node);
            visited[node] = true;
        }
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (Pipe next : tree.get(cur)) {
                if (visited[next.to] || next.type != type) continue;
                queue.offer(next.to); // 현재 단계 전파 확인용
                infected.add(next.to); // 최종 결과물
                visited[next.to] = true;
            }
        }
    }
}