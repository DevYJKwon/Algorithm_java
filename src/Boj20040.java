import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20040 {
	
	static void makeSet() {
		for(int i=0; i<n; i++) {
			parents[i]=i;
		}
	}
	
	static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return false;
		}
		
		if(aRoot < bRoot) {
			parents[bRoot]=aRoot;
		}
		else {
			parents[aRoot]=bRoot;
		}
		return true;
	}
	static int n;
	static int [] parents;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt=0;
		parents= new int[n];
		makeSet();
		for(int i=1; i<=m && cnt < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(union(from,to)) {
				cnt++;
			}
			else {
				System.out.println(i);
				return;
			}
		}
		System.out.println(0);
	}

}
