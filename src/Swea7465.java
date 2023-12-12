import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Swea7465 {
	
	static int [] parents;
	
	
	static int find(int a) {
		if(parents[a]==a) {
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
		if(aRoot > bRoot) {
			int temp = aRoot;
			aRoot = bRoot;
			bRoot = temp;
		}
		parents[bRoot]=aRoot;
		return true;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		HashSet<Integer> set = new HashSet<>();
		for(int t=1; t<= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 노드의 개수
			int m = Integer.parseInt(st.nextToken()); // 엣지의 개수
			parents = new int [n+1];
			
			
			//makeSet
			for(int i=1; i<n+1; i++) {
				parents[i]=i;
			}
			int success = 0;
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				if(union(from,to)) {
					success++;
				}
			}
			
			if(success >= n-1) {
				sb.append(String.format("#%d %d\n", t,1));
			}
			else {
				for(int i=1; i<n+1; i++) {
					set.add(find(i));
				}
				sb.append(String.format("#%d %d\n", t,set.size()));
				set.clear();
			}
		}
		System.out.println(sb);
	}

}
