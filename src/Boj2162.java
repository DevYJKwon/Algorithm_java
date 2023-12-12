import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2162 {
	static int[] parents;

	static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}

		if (aRoot < bRoot) {
			int temp = aRoot;
			aRoot = bRoot;
			bRoot = temp;
		}

		parents[bRoot] = aRoot;
		return true;
	}

	static class Line {
		int i;
		Point a, b;

		public Line(int i, Point a, Point b) {
			super();
			this.i = i;
			this.a = a;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Line [i=" + i + ", a=" + a + ", b=" + b + "]";
		}
		
	}

	static int ccw(Point a, Point b, Point c) {
		long res = (a.x * b.y + b.x * c.y + c.x * a.y) - (b.x * a.y + c.x * b.y + a.x * c.y);
		if (res > 0) {
			return 1;
		} else if (res == 0) {
			return 0;
		} else {
			return -1;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Line[] lines = new Line[n];
		int [] group = new int [n];

		parents = new int[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			lines[i] = new Line(i, a, b);
		}

		// makeSet
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				Line a = lines[i];
				Line b = lines[j];
				int res1 = ccw(a.a, a.b, b.a) * ccw(a.a, a.b, b.b);
				int res2 = ccw(b.a, b.b, a.a) * ccw(b.a, b.b, a.b);
				if(res1 <= 0 && res2 <=0) {
					if(Math.min(a.a.x, a.b.x) <= Math.max(b.a.x,b.b.x) && Math.max(a.a.x,a.b.x) >= Math.min(b.a.x, b.b.x)&& Math.min(a.a.y, a.b.y) <= Math.max(b.a.y,b.b.y) && Math.max(a.a.y,a.b.y) >= Math.min(b.a.y, b.b.y)) {
						union(a.i,b.i);
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			group[find(i)]++;
		}
		int cnt=0,max=0;
		for(int i=0; i<n; i++) {
			if(group[i]>0) {
				cnt++;
			}
			max = Math.max(max, group[i]);
		}
		System.out.println(cnt);
		System.out.println(max);
	}

}
