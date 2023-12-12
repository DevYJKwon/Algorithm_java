import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea5643 {

	static List<List<Integer>> normal;
	static List<List<Integer>> reverse;
	static int n, m;
	static StringBuilder sb = new StringBuilder();
	
	static boolean check(int target) {
		boolean []visited = new boolean [n+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(target);
		
		//부모 노드 개수 찾기
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<reverse.get(cur).size(); i++) {
				int next = reverse.get(cur).get(i);
				if(!visited[next]) {
					visited[next]=true;
					q.add(next);
				}
			}
		}
		
		//자식 노드 개수 찾기
		q.clear();
		q.add(target);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<normal.get(cur).size(); i++) {
				int next = normal.get(cur).get(i);
				if(!visited[next]) {
					visited[next]=true;
					q.add(next);
				}
			}
		}
		
		int cnt=0;
		for(int i=1; i<=n; i++) {
			if(visited[i]) {
				cnt++;
			}
		}
		if(cnt ==n-1) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int testCase =1; testCase <= t; testCase++) {
			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());

			normal = new ArrayList<>();
			reverse = new ArrayList<>();

			for (int i = 0; i <= n; i++) {
				normal.add(new ArrayList<>());
				reverse.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				normal.get(from).add(to);
				reverse.get(to).add(from);
			}
			int cnt = 0;

			for (int i = 1; i <= n; i++) {
				if (check(i)) {
					cnt++;
				}
			}
			sb.append(String.format("#%d %d\n", testCase,cnt));
		}
		System.out.println(sb);
	}

}
