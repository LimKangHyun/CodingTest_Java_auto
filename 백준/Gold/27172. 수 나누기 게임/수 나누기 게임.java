import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] cards;
    private static int[] idx;
    private static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        cards = new int[N+1];
        idx = new int[1000001];
        score = new int[N+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            idx[cards[i]] = i;
            
        } 
        findScore();
        for (int i = 1; i <= N; i++) {
            sb.append(score[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    private static void findScore() {
        for (int i = 1; i <= N; i++) {
            for (int j = cards[i] * 2; j < 1000001; j += cards[i]) {
                if (idx[j] >= 1) {
                    score[i]++;
                    score[idx[j]]--;
                } 
            } 
        }
    }
}