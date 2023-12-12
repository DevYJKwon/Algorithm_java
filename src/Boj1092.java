import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> crain = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int c = Integer.parseInt(st.nextToken());
			crain.add(c);
		}
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int t = Integer.parseInt(st.nextToken());
			list.add(t);
		}
		Collections.sort(crain, Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder());
		
		if(list.get(0) > crain.get(0)) {
			System.out.println(-1);
			return;
		}
		
		
		int time=0;
		while(!list.isEmpty()) {
			int i=0;
			for(int c=0; c<n;) {
				if(i==list.size()) {
					break;
				}
				if(crain.get(c) >= list.get(i)) {
					list.remove(i);
					c++;
				}
				else {
					i++;
				}
			}
			time++;
		}
		System.out.println(time);
	}

}
