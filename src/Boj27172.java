import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj27172 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] list = new int[n];
		int[] point = new int[1000001];
		boolean[] exist = new boolean[1000001];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			list[i] = num;
			exist[num] = true;
		}

		for (int num : list) {
			for(int i=2; i*num <= 1000000; i++) {
				if(exist[i*num]) {
					point[i*num]--;
					point[num]++;
				}
			}
		}

		for(int num : list) {
			sb.append(point[num] + " ");
		}
		System.out.println(sb);
	}

}
