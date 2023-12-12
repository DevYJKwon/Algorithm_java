import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1233 {
	static String[] arr;
	static boolean[] visited;

	static void dfs(int v) {
		visited[v] = true;
		System.out.println(arr[v]);
		for (int i = 1; i < arr.length; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {

			int size = Integer.parseInt(br.readLine());
			arr = new String[size + 1];
			visited = new boolean[size + 1];

			for (int i = 0; i < size; i++) {
				st = new StringTokenizer(br.readLine());
				int n = Integer.parseInt(st.nextToken());
				String node = st.nextToken();
				arr[n] = node;
				while(st.hasMoreTokens()) {
					st.nextToken();
				}
			}
			int res =1;
			outer:for(int i=size; i>=3; i-=2) {
				for(int j=0; j<arr[i].length(); j++) {
					if(!Character.isDigit(arr[i].charAt(j))) {
						res=0;
						break outer;
					}
					
					if(!Character.isDigit(arr[i-1].charAt(j))) {
						res=0;
						break outer;
					}
				}
				if(Character.isDigit(arr[i/2].charAt(0))) {
					res=0;
					break outer;
				}
				arr[i/2] = "1";
			}
			sb.append(String.format("#%d %d\n", t,res));

		}
		System.out.println(sb);
	}

}

