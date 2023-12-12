import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj9375 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		for(int t=0; t<testCase; t++) {
			HashMap<String,List<String>> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String v = st.nextToken();
				String k = st.nextToken();
				if(!map.containsKey(k)) {
					map.put(k, new ArrayList<String>());				
				}
				map.get(k).add(v);
			}
			
			int sum=n;
			
		}
		
	}

}
