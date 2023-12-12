import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj12014 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			st= new StringTokenizer(br.readLine());
			
			List<Integer> lis = new ArrayList<>();
			lis.add(Integer.parseInt(st.nextToken()));
			for(int i=1; i<n; i++) {
				int next = Integer.parseInt(st.nextToken());
				
				if(lis.get(lis.size()-1) < next) {
					lis.add(next);
				}
				else {
					int idx = Collections.binarySearch(lis, next);
					if(idx < 0) {
						idx = Math.abs(idx)-1;
					}
					lis.set(idx, next);
				}
			}
			sb.append("Case #").append(t).append("\n").append(lis.size() >= goal? 1:0).append("\n");
		}
		System.out.println(sb);
	}

}
