import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Boj1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Deque<Point> q; // x: priority y:index
		TreeSet<Integer> table;
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < testCase; t++) {
			table = new TreeSet<>();
			q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int max = 1;
			for (int i = 0; i < n; i++) {
				int p = Integer.parseInt(st.nextToken());
				max = Math.max(max, p);
				table.add(p);
				q.addFirst(new Point(p, i));
			}

			int cnt = 0;
			outer: while (!q.isEmpty()) {
				Point cur = q.removeLast();
				if (cur.x < max) {
					q.addFirst(cur);
				}
				else {
					cnt++;
					if (cur.y == target) {
						sb.append(cnt).append("\n");
						break outer;
					}	
					
					for(Point p : q) {
						if(p.x == max) {
							continue outer;
						}
					}
					max = table.lower(max);
				}
			}
		}
		System.out.println(sb);
	}

}
