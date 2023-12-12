import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1365 {
	static int binarySearch(int start, int end, int target) {
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (lis[mid] < target) {
				start = mid + 1;
			} else {
				end = mid;
			}
		}
		return end;
	}

	static int[] lis;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[n];
		lis = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		lis[0] = arr[0];
		int len = 0, i = 1;

		while (i < n) {
			if (lis[len] < arr[i]) {
				lis[++len] = arr[i];
			} else {
				int idx = binarySearch(0, len, arr[i]);
				lis[idx] = arr[i];
			}
			i++;
		}
		int res = n-(len+1);

		System.out.println(res);

	}
}
