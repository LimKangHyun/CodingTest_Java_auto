import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[1000001];
        int[] num = new int[N+1];
        int[] save = new int[1000001];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int t=Integer.valueOf(st.nextToken());
            visit[t] = true;
            num[i] = t;
        }

        for(int i = 1; i <= N; i++){
            int t = num[i];
            for(int j = 1; j <= Math.sqrt(t); j++){
                if(t%j != 0){
                    continue;
                }
                if(visit[j]){
                    save[j]++;
                    save[t]--;
                }
                if(j*j != t && visit[t/j]){
                    save[t/j]++;
                    save[t]--;
                }
            }

        }
        for(int i = 1; i <= N; i++){
            sb.append(save[num[i]] + " ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}