import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**

@author 권용재
@since 2023. 8. 1.
@see
@git
@youtube
@performance
@category #
@note */

public class sweaFlattern {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		for(int t =0; t<10; t++) {
			
			int dump = Integer.parseInt(br.readLine());
			st=new StringTokenizer(br.readLine());
			int [] map = new int[100];
			for(int i=0; i<100; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			while(dump > 0) {
				int max=0;
				int min=0;
				for(int i=0; i<100; i++) {
					if(map[max] < map[i]) {
						max = i;
					}
					if(map[min] > map[i]) {
						min =i;
					}
				}	
				if(map[max] == map[min]) {
					break;
				}
				map[max]--;
				map[min]++;
				dump--;
			}
			int max=0;
			int min=Integer.MAX_VALUE;
			for(int i =0; i<100; i++) {
				max = Math.max(map[i], max);
				min = Math.min(map[i], min);
			}
			sb.append(String.format("#%d %d\n", t+1,max-min));
		}
		System.out.print(sb);
	}

}
