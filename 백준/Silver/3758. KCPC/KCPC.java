import java.io.*;
import java.util.*;

class Team implements Comparable<Team> {
    int id;
    int score;
    int totalSubmit;
    int lastSubmit;
    
    public Team(int id, int score, int totalSubmit, int lastSubmit) {
        this.id = id;
        this.score = score;
        this.totalSubmit = totalSubmit;
        this.lastSubmit = lastSubmit;
    }
    
    @Override
    public int compareTo(Team o) {
        if (this.score != o.score) return o.score - this.score;
        if (this.totalSubmit != o.totalSubmit) return this.totalSubmit - o.totalSubmit;
        return this.lastSubmit - o.lastSubmit;
    }
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int n = Integer.parseInt(st.nextToken()); // 팀의 개수
		    int k = Integer.parseInt(st.nextToken()); // 문제 개수
		    int t = Integer.parseInt(st.nextToken()); // 내팀 ID
		    int m = Integer.parseInt(st.nextToken());
		    Team[] team = new Team[n + 1];
		    for (int i = 1; i <= n; i++) {
		        team[i] = new Team(0, 0, 0, 0);
		    }
		    int[][] teamScore = new int[n + 1][k + 1];
		    for (int d = 0; d < m; d++) {
		        st = new StringTokenizer(br.readLine());
		        int i = Integer.parseInt(st.nextToken()); // 팀 ID
		        int j = Integer.parseInt(st.nextToken()); // 문제 번호
		        int s = Integer.parseInt(st.nextToken()); // 문제 점수
		        team[i].id = i;
		        team[i].totalSubmit++;
		        team[i].lastSubmit = d;
		        teamScore[i][j] = Math.max(teamScore[i][j], s);
		    }
		    for (int i = 1; i <= n; i++) {
		        for (int j = 1; j <= k; j++) {
		            team[i].score += teamScore[i][j];
		        }
		    }
		    PriorityQueue<Team> pq = new PriorityQueue<>();
		    for (int i = 1; i <= n; i++) {
		        pq.offer(team[i]);
		    }
		    for (int i = 1; i <= n; i++) {
		        if (pq.poll().id == t) {
		            sb.append(i).append("\n");
		            break;
		        }
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}