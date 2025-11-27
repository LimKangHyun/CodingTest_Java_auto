import java.io.*;
import java.util.*;

class Stud implements Comparable<Stud> {
    String name;
    int kuk;
    int young;
    int su;
    
    Stud(String name, int kuk, int young, int su) {
        this.name = name;
        this.kuk = kuk;
        this.young = young;
        this.su = su;
    }
    @Override
    public int compareTo(Stud o) {
        if (this.kuk != o.kuk) return Integer.compare(o.kuk, this.kuk);
        if (this.young != o.young) return Integer.compare(this.young, o.young);
        if (this.su != o.su) return Integer.compare(o.su, this.su);
        return this.name.compareTo(o.name);
    }
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stud[] studs = new Stud[N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    String name = st.nextToken();
		    int kuk = Integer.parseInt(st.nextToken());
		    int young = Integer.parseInt(st.nextToken());
		    int su = Integer.parseInt(st.nextToken());
		    studs[i] = new Stud(name, kuk, young, su);
		}
		Arrays.sort(studs);
		for (Stud s : studs) {
		    sb.append(s.name).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}