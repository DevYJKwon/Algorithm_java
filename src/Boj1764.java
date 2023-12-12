import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Boj1764 {
	
	/*
	 * 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		TreeMap<String, Boolean> map = new TreeMap<>();
		
		for(int i=0; i <n; i++) {
			String d = br.readLine();
			map.put(d, false);
		}
		
		for(int i=0; i<m; i++) {
			String b = br.readLine();
			if(map.containsKey(b)) {
				map.put(b, true);
			}
		}
		int cnt=0;
		for(Entry<String,Boolean> e : map.entrySet()) {
			if(e.getValue()) {
				cnt++;
				sb.append(e.getKey()).append("\n");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

}
