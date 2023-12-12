import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Boj2295 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		List<Integer> sum = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				sum.add(arr[i]+arr[j]);
			}
		}
		Collections.sort(sum);
		for(int i=arr.length-1; i >=0; i--) {
			for(int j=0; j < arr.length; j++) {
				int target = arr[i]-arr[j];
				if(Collections.binarySearch(sum, target) > -1) {
					System.out.println(arr[i]);
					return;
				}
			}
		}

	}

}
