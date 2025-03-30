import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int person = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        
        List<Integer> que = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= person; i++) {
            que.add(i);
        }
        
        int i = 0;
        while(!que.isEmpty()) {
            i = (i + num - 1) % que.size();
            if(que.size() != 1) {
                sb.append(que.get(i)).append(", ");
            } else {
                sb.append(que.get(i));
            }
            que.remove(i);
        }
        bw.write("<" + sb + ">");
        bw.flush();
    }
}