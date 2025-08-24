import java.io.*;
import java.util.*;
// 3월 1일 부터 11월 30일까지 한 가지 이상 꽃
public class Main {
    static int[][] flower;
    static int N;
    static int START = 301;
    static int END = 1130;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		flower = new int[N][2];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int sMonth = Integer.parseInt(st.nextToken());
		    int sDay = Integer.parseInt(st.nextToken());
		    int eMonth = Integer.parseInt(st.nextToken());
		    int eDay = Integer.parseInt(st.nextToken());
		    flower[i][0] = sMonth * 100 + sDay;
		    flower[i][1] = eMonth * 100 + eDay;
		} 
		Arrays.sort(flower, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]));
		
		bw.write(String.valueOf(findMinCount()));
		bw.flush();
	}
	private static int findMinCount() {
		int current = START;
		int count = 0;
		int idx = 0;
		while(current <= END) {
		    int lastDay = current;
		    while(idx < N && flower[idx][0] <= current) { // 이 조건이 안맞으면 실패
		        lastDay = Math.max(lastDay, flower[idx][1]); // 가장 긴 끝점으로 갱신
                idx++;
		    }
		    if (lastDay == current) return 0; // 이어가지 못함
	        count++;
	        current = lastDay;
		}
		return count;
	}
}