import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11724 {

	//연결 요소의 개수를 구하기 때문에, 각 요소들의 집합을 만들고 집합의 개수를 구한다.
	
	static int [] parents;
	static void makeSet() {
		for(int i=1; i<parents.length; i++) {
			parents[i]=i;
		}
	}
	static int find(int a) {
		if(a==parents[a]) {
			return a;
		}
		return parents[a]=find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot =find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parents = new int [v+1];
		makeSet();
		int cnt=0;
		for(int i=0; i<e && cnt < v-1; i++) { //v-1만큼 간선을 연결하면 모든 정점들을 연결한 것이다.
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			if(union(from,to)) {
				cnt++;
			}
		}
		System.out.println(v-cnt);
	}

}
