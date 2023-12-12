import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj3830 {
	static int [] parents;
	static HashMap<Integer,Integer> [] maps;
	
	static void makeSet(int n) {
		parents = new int [n+1];
		for(int i=1; i<=n; i++) {
			parents[i]=i;
		}
	}
	
	
	static int find(int a) {
		if(a == parents[a]) {
			return a;
		}
		
		return parents[a]=find(parents[a]);
	}
	
	
	static boolean union(int a, int b,int w) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}
		parents[aRoot] = bRoot;
		return true;
	}
	
	static String check(int a, int b) {
		int root = find(a);
		if(root == b) {
			return Integer.toString(root);
		}
		
		return "UNKOWN";
	}
	
	static void printSet(int n) {
		for(int i=1; i<=n; i++) {
			System.out.print(parents[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			makeSet(n);
			if(n==0 && m==0) {
				break;
			}
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(command == '!') {
					int w = Integer.parseInt(st.nextToken());
					union(a,b,w);
					printSet(n);
				}
				else {
					sb.append(check(a,b)).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}
