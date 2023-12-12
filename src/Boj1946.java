import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj1946 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=0; t<testCase; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			TreeMap<Integer,Integer> map = new TreeMap<>();
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int a =Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map.put(a, b);
			}
			int min = n+1;
			int cnt=0;
			for(int b : map.values()) {
				if(b < min) {
					min = b;
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
