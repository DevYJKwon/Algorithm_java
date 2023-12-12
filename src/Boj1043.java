import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1043 {
	static int[] parents;
	static int[] level;
	static int n, m;
	static int kParent;

	static void makeSet() {
		for (int i = 0; i <= n; i++) {
			parents[i] = i;
			level[i] = 1;
		}

	}

	static int find(int a) {
		if (parents[a] == a) {
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
		if (aRoot == kParent) {
			parents[bRoot] = aRoot;
		} else if (bRoot == kParent) {
			parents[aRoot] = bRoot;
		} else if (level[aRoot] >= level[bRoot]) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 사람 수
		m = Integer.parseInt(st.nextToken()); // 파티 수
		parents = new int[n + 1];
		level = new int[n + 1];
		makeSet();
		st = new StringTokenizer(br.readLine());
		int kNum = Integer.parseInt(st.nextToken());
		if (kNum != 0) {
			kParent = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < kNum - 1; i++) {
			int knower = Integer.parseInt(st.nextToken());
			parents[knower] = kParent;
		}
		int cnt = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			list.add(new ArrayList<>());
		}

		for (int p = 0; p < m; p++) {
			st = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(st.nextToken());
			int pParent = Integer.parseInt(st.nextToken());
			list.get(p).add(pParent);
			for (int i = 0; i < pNum - 1; i++) {
				int talker = Integer.parseInt(st.nextToken());
				union(pParent, talker);
			}
		}
		for (int p = 0; p < m; p++) {

			int talker = list.get(p).get(0);
			if (find(talker) == kParent) {
				continue;
			}
				cnt++;
		}
		System.out.println(cnt);
	}

}
