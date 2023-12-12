import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class test {
	static int n,min;
	static List<Integer> [] graph;
	static int [] nodes;
	static void makeSubSet(int nth, boolean[] chosen) {
		if(nth == chosen.length) {
			List<Integer> a = new ArrayList<>();
			List<Integer> b = new ArrayList<>();
			for(int i=0; i<chosen.length; i++) {
				if(chosen[i]) {
					a.add(i+1);
					continue;
				}
				b.add(i+1);
			}
			if(a.size() == 0 || b.size()==0) { // 한 지역구가 비어있는 경우 제외
				return;
			}
			if(checkConnection(a)&&checkConnection(b)) { // 연결되어 있는지 체크
				int aSum=0,bSum=0;
				for(int i:a) {
					aSum+=nodes[i];
				}
				for(int i:b) {
					bSum+=nodes[i];
				}
				min = Math.min(min, Math.abs(aSum-bSum));
			}
			return;
		}
		chosen[nth]=true;
		makeSubSet(nth+1, chosen);
		chosen[nth]=false;
		makeSubSet(nth+1, chosen);
	}
	static boolean checkConnection(List<Integer> list) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean [] visited = new boolean [n+1];
		q.add(list.get(0));
		while(!q.isEmpty()) {
			int cur = q.poll();
			visited[cur]=true;
			for(int next : graph[cur]) {
				if(!visited[next] && list.contains(next)) {
					q.add(next);
				}
			}
		}
		int cnt=0;
		for(int i=1; i <= visited.length; i++) {
			if(list.contains(i) && visited[i]) {
				cnt++;
			}
		}
		if(cnt == list.size()) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int testCase =1; testCase<=T; testCase++) {
			n = Integer.parseInt(br.readLine());
			nodes = new int [n+1];
			graph = new List[n+1];
			
			for(int i=1; i<=n; i++) {
				graph[i]= new ArrayList<Integer>();
			}
			for(int from=1; from<=n; from++) {
				st = new StringTokenizer(br.readLine());
				for(int to=1; to<=n; to++) {
					int isConnect = Integer.parseInt(st.nextToken());
					if(isConnect == 0) {
						continue;
					}
					graph[from].add(to);
				}
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) {
				nodes[i]=Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			makeSubSet(0,new boolean [n]);
			sb.append(String.format("#%d %d\n", testCase,min));
		}
		System.out.println(sb);
	}

}