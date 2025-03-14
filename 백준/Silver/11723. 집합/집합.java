import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int M = Integer.parseInt(br.readLine()); // 수행해야 하는 연산의 수
        
        boolean[] set = new boolean[21]; // 1부터 20까지의 값을 다루기 위한 배열 (0번 인덱스는 사용 안 함)
        
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "add":
                    int addNum = Integer.parseInt(st.nextToken());
                    set[addNum] = true;
                    break;
                
                case "remove":
                    int removeNum = Integer.parseInt(st.nextToken());
                    set[removeNum] = false;
                    break;
                
                case "check":
                    int checkNum = Integer.parseInt(st.nextToken());
                    sb.append(set[checkNum] ? 1 : 0).append("\n");
                    break;
                
                case "toggle":
                    int toggleNum = Integer.parseInt(st.nextToken());
                    set[toggleNum] = !set[toggleNum];
                    break;
                
                case "all":
                    for (int i = 1; i <= 20; i++) {
                        set[i] = true;
                    }
                    break;
                
                case "empty":
                    for (int i = 1; i <= 20; i++) {
                        set[i] = false;
                    }
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}