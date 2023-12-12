import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Boj2568 {
	/*
	 * lis 문제 입력된 시작 , 끝 전깃줄 간선 받아서 배열에 저장 lis구하기 끊어야하는 전깃줄 -> min(lis가 아닌,lis인 경우)
	 */
	static class Node {
		int v, i;

		public Node(int v, int i) {
			super();
			this.v = v;
			this.i = i;
		}
	}

	static TreeMap<Integer, Integer> fromMap = new TreeMap<>();
	static TreeMap<Integer, Integer> toMap = new TreeMap<>();
	static List<Integer> lis = new ArrayList<>();

	static int binarySearch(int start, int end, int target) {
		while (start < end) {
			int mid = (start + end) / 2;
			if (lis.get(mid) < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		List<Node> list = new ArrayList<>();
		TreeSet<Integer> no = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			fromMap.put(from, to);
			toMap.put(to, from);
		}
		lis.add(fromMap.get(fromMap.firstKey()));
		// lis 만들기
		for (Entry<Integer, Integer> entry : fromMap.entrySet()) {
			int k = entry.getKey();
			int v = entry.getValue();

			if (lis.get(lis.size() - 1) < v) {
				lis.add(v);
				list.add(new Node(v, lis.size() - 1));
			} else {
				int idx = binarySearch(0, lis.size() - 1, v);
				lis.set(idx, v);
				list.add(new Node(v, idx));
			}
		}
		// lis 원소 구하기
		int idx = lis.size() - 1;
		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).i == idx) {
				lis.set(idx, list.get(i).v);
				idx--;
			} else {
				no.add(toMap.get(list.get(i).v));
			}
		}

		// 끊어야하는 전깃줄 구하기
		// lis가 아닌 것들
		sb.append(n - (lis.size())).append("\n");
		for (int i : no) {
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}

}
