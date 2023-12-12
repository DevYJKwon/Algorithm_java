import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1421 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //나무 개수
		int c = Integer.parseInt(st.nextToken()); // 나무 당 벌목 비용
		int w = Integer.parseInt(st.nextToken()); // 길이 당 가격
		int [] arr = new int [n];
		int max =0;
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}
		long res=0;
		for(int length=1; length<=max; length++) {
			long profit=0;
			for(int i=0; i<n; i++) {
				int woods = arr[i]/length;
				
				if(woods==0) {
					continue;
				}
				
				if(arr[i] == length) {
					profit += length*w;
				}
				else if(arr[i]%length==0) {
					if(woods*w*length - (woods-1)*c > 0) {
						profit += woods*w*length - (woods-1)*c;
					}
				}
				else {
					if(length*w*woods - woods*c > 0) {
						profit += length*w*woods - woods*c;
					}
				}
			}
			res = Math.max(profit, res);
		}
		System.out.println(res);
	}

}
