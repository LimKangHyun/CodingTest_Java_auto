import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
		    int N = Integer.parseInt(br.readLine());
		    int[] runner = new int[N + 1];
		    int totalTeam = 0;
		    st = new StringTokenizer(br.readLine());
		    for (int i = 1; i <= N; i++) {
		        runner[i] = Integer.parseInt(st.nextToken());
		        totalTeam = Math.max(totalTeam, runner[i]);
		    }
		    int[] teamCount = new int[totalTeam + 1];
		    for (int i = 1; i <= N; i++) {
		        teamCount[runner[i]]++;
		    }
		    int[] orderCount = new int[totalTeam + 1]; // 현재 몇 명까지 들어왔는지
		    int[] teamScore = new int[totalTeam + 1]; // 팀 점수 (4등 까지만 저장)
		    int[] fifth = new int[totalTeam + 1]; // 각 팀 5등 랭크
		    int rank = 1;
		    for (int i = 1; i <= N; i++) {
		        int teamNum = runner[i];
		        if (teamCount[teamNum] < 6) continue;
		        orderCount[teamNum]++;
		        if (orderCount[teamNum] <= 4) teamScore[teamNum] += rank;
		        else if (orderCount[teamNum] == 5) fifth[teamNum] = rank;
		        rank++;
		    }
		    int winner = 0;
		    int minScore = Integer.MAX_VALUE;
		    for (int i = 1; i <= totalTeam; i++) {
		        if (teamCount[i] < 6) continue;
		        if (minScore > teamScore[i]) {
		            minScore = teamScore[i];
		            winner = i;
		        }
		        if (minScore == teamScore[i]) {
		            if (fifth[winner] < fifth[i]) continue;
		            winner = i;
		        }
		    }
		    sb.append(winner).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}