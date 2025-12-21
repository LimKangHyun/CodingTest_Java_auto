import java.io.*;
import java.util.*;

class Task {
    int d;
    int w;
    Task(int d, int w) {
        this.d = d;
        this.w = w;
    }
}
public class Main {
    static int sum = 0;
    static int maxDay = 0;
    static int[] days;
    static List<Task> tasks = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int d = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    maxDay = Math.max(maxDay, d);
		    tasks.add(new Task(d, w));
		}
		days = new int[maxDay + 1];
		Collections.sort(tasks, (a, b) -> b.w - a.w); // 점수 기준 내림차순
		for (Task task : tasks) {
		    for (int day = task.d; day >= 1; day--) {
		        if (days[day] == 0) {
		            days[day] = task.w;
		            sum += task.w;
		            break;
		        }
		    }
		}
		bw.write(String.valueOf(sum));
		bw.flush();
	}
}