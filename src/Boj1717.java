import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1717 {
	static int [] parents;
	
	static String check(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) {
			return "YES";
		}
		return "NO";
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
		
		if(bRoot < aRoot) {
			parents[bRoot] = aRoot;
		}
		else {
			parents[aRoot] = bRoot;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		parents = new int [n+1];
		for(int i=0; i<=n; i++) {
			parents[i]=i;
		}
		
		for(int i=0; i<m; i++) {
			st= new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(command == 0) {
				union(a,b);
			}
			else {
				sb.append(check(a,b)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
