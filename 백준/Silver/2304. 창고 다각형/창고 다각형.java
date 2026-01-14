import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] pillar = new int[N][2];
		
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int L = Integer.parseInt(st.nextToken());
		    int H = Integer.parseInt(st.nextToken());
		    pillar[i][0] = L;
		    pillar[i][1] = H;
		}
		Arrays.sort(pillar, (a, b) -> a[0] - b[0]);
		int maxH = 0;
		int maxHIdx = 0;
		for (int i = 0; i < N; i++) {
		    if (pillar[i][1] > maxH) {
		        maxH = pillar[i][1];
		        maxHIdx = i;
		    }
		}
		int startMaxIdx = -1;
		int endMaxIdx = -1;
		for (int i = 0; i < N; i++) {
		    if (pillar[i][1] == maxH) {
		        if (startMaxIdx == -1) startMaxIdx = i; // 처음 시작하는 가장 높은 높이의 idx
		        endMaxIdx = i; // 가장 높은 높이가 끝나는 idx
		    }
		}
		// maxH의 idx기준 왼쪽
		int beforeH = pillar[0][1];
		int beforeIdx = pillar[0][0];
		int leftArea = 0;
		for (int i = 0; i < maxHIdx; i++) {
		    if (pillar[i][1] > beforeH) {
		        int tmp = beforeH * (pillar[i][0] - beforeIdx);
		        leftArea += tmp;
		        beforeH = pillar[i][1];
		        beforeIdx = pillar[i][0];
		    }
		}
		leftArea += beforeH * (pillar[startMaxIdx][0] - beforeIdx);
		
		// maxH의 idx기준 오른쪽 (maxHIdx 포함)
		beforeH = pillar[N - 1][1];
		beforeIdx = pillar[N - 1][0];
		int rightArea = 0;
		for (int i = N - 1; i >= maxHIdx; i--) {
		    if (pillar[i][1] > beforeH) {
		        int tmp = beforeH * (beforeIdx - pillar[i][0]);
		        rightArea += tmp;
		        beforeH = pillar[i][1];
		        beforeIdx = pillar[i][0];
		    }
		}
		rightArea += beforeH * (beforeIdx - pillar[endMaxIdx][0]);
		
		int maxL = pillar[endMaxIdx][0] - pillar[startMaxIdx][0]; // 최대 높이가 두 개 이상 있는 경우 그 왼쪽부터 오른쪽 까지의 길이
		int total = leftArea + rightArea + maxH * (maxL + 1);
		bw.write(String.valueOf(total));
		bw.flush();
	}
}