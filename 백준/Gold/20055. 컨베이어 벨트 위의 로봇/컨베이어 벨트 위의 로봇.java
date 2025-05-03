import java.io.*;
import java.util.*;
// 리팩토링
public class Main {
    static class Belt {
        int dur;
        boolean isRobot;
        
        public Belt(int dur) {
            this.dur = dur;
            this.isRobot = false;
        }
    }
    private static int N, K;
    private static List<Belt> belt;
    private static int zeroCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            belt.add(new Belt (Integer.parseInt(st.nextToken())));
        } 
        int stage = 0;
        while(zeroCount < K) {
            stage++;
            moveBelt();
            removeEndRobot();
            moveRobots();
            removeEndRobot();
            placeRobot();
        }
        bw.write(String.valueOf(stage));
        bw.flush();
    }
    private static void moveBelt() {
        belt.add(0, belt.remove(belt.size() - 1));
    }
    private static void moveRobots() {
        for (int i = N - 2; i >= 0; i--) {
            if (belt.get(i).isRobot && !belt.get(i+1).isRobot && belt.get(i+1).dur >= 1) {
                belt.get(i).isRobot = false;
                belt.get(i+1).isRobot = true;
                belt.get(i+1).dur--;
                if (belt.get(i+1).dur == 0) zeroCount++; 
            }
        } 
    }
    private static void removeEndRobot() {
        if (belt.get(N-1).isRobot) belt.get(N-1).isRobot = false; 
    }
    private static void placeRobot() {
        if (!belt.get(0).isRobot && belt.get(0).dur >= 1) {
            belt.get(0).isRobot = true;
            belt.get(0).dur--;
            if (belt.get(0).dur == 0) zeroCount++; 
        } 
    }
}