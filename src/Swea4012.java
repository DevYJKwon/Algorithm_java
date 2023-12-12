import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea4012 {
	static int [][] map;
	static int min,n,total;
	static int [] arr;
	
	/*
	 *  2명에게 n/2개씩 재료써서 맛의 차이가 최소가 되도록 비슷하게 만들기
	 *   i와 j와 섞이면 시너지가 생기는데 시너지의 총합 = 음식의 맛
	 *   Sij + Sji = food
	 */
	static void comb(int r, int start, int [] choosed) {
		if(r == choosed.length) {
			boolean [] check =  new boolean[n];
			int [] other = new int[n/2];
			int idx=0;
			for(int i=0;i<choosed.length; i++) {
				check[choosed[i]]=true;
			}
			for(int i=0; i<check.length; i++) {
				if(!check[i]) {
					other[idx++]=i;
				}
			}
			int sum1=0,sum2=0;
			for(int i=0; i<choosed.length; i++) {
				
				for(int j=0; j<choosed.length; j++) {
					sum1+=map[choosed[i]][choosed[j]];
					sum2+=map[other[i]][other[j]];
				}
			}
			int diff = Math.abs(sum1-sum2);
			
			min = Math.min(diff, min);
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			choosed[r]=arr[i];
			comb(r+1, i+1, choosed);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int t =1; t<=testCase; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			arr=new int[n];
			total=0;
			for(int i=0; i<n; i++) {
				arr[i]=i;
			}
			for(int y=0; y<n; y++) {
				st= new StringTokenizer(br.readLine());
				for(int x=0; x<n; x++) {
					map[y][x]= Integer.parseInt(st.nextToken());
					total+=map[y][x];
				}
			}
			min = Integer.MAX_VALUE;
			comb(0, 0, new int[n/2]);
			sb.append(String.format("#%d %d\n", t,min));
		}
		System.out.println(sb);
	}

}
