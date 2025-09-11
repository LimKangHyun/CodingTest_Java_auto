import java.io.*;
import java.util.*;

public class Main {
    static int diffX, diffY;
    static Map<Integer, Integer> copyMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][2];
        Map<Integer, Integer> answer = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        } 
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        } 
        int[][] diff = new int[n][2];
        // 정답 중 하나를 골라서 모든 map의 점과의 x, y 차이 계산하기
        int cx = arr[0][0];
        int cy = arr[0][1];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            diff[idx][0] = cx - key;
            diff[idx][1] = cy - value;
            idx++;
        }
        for (int i = 0; i < n; i++) {
            copyMap = new HashMap<>(map);
            diffX = diff[i][0];
            diffY = diff[i][1];
            for (int j = 0; j < m; j++) {
                copyMap.put(arr[j][0] - diffX, arr[j][1] - diffY);
            } 
            if (map.size() == copyMap.size()) break;
        } 
        bw.write(-diffX + " " + (-diffY));
        bw.flush();
    }
}