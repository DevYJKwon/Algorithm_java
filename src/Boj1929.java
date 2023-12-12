import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		boolean [] arr = new boolean [1000001];
		arr [0]= true;
		arr [1] = true;
		
		for(int i=2; i<arr.length; i++) {
			if(!arr[i]) {
				int cnt=2;
				while(i*cnt < arr.length) {
					arr[i*cnt++]=true;
				}
			}
		}
		
		for(int i = start; i <= end; i++) {
			if(!arr[i]) {
				sb.append(i).append("\n");
			}
		}
		System.out.print(sb);
	}

}
