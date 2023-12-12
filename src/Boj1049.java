import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1049 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] line = new int[2];
		line[0] = 1001;
		line[1] = 1001;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			line[0] = Math.min(p, line[0]);
			line[1] = Math.min(s, line[1]);
		}
		int sum=0;
		if(line[0] < line[1]*6) {
			sum = (int) Math.min(line[0]*Math.ceil(target/6.0), line[1]*(target%6) + line[0]*(target/6));
		}
		else {
			sum = line[1]*target;
		}
		System.out.println(sum);
	}

}
