import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1208 {
	/*
	 * 
	 * 한 개 선택
	 * 그 수를 기준으로 양쪽으로 탐색 시작
	 * 
	 */
	
	public static void main(String[] args) throws IOException	{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int []arr = new int [n];
		for(int i=0; i<n; i++){
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		
	}

}
