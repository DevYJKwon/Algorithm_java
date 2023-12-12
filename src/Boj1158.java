import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Boj1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Deque<Integer> q = new ArrayDeque<Integer>();
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for(int i=1; i<=n; i++) {
			q.addFirst(i);
		}
		while(!q.isEmpty()) {
			for(int i=0; i<k-1; i++) {
				int tmp = q.removeLast();
				q.addFirst(tmp);
			}
			int tar = q.removeLast();
			sb.append(tar+", ");
		}

		sb.replace(sb.length()-2, sb.length(), "");
		sb.append(">\n");
		System.out.println(sb);
	}

}
