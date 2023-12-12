import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1244 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int [n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		arr[0]=-1;
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if(sex==1) {
				for(int s=num; s<arr.length; s+=num) {
					arr[s]= arr[s] == 0 ? 1:0;
				}
			}
			else {
				int start=num,end=num;
				int l=num,h=num;
				while(l >0 && h < arr.length) {
					if(arr[l] == arr[h]) {
						start = l;
						end=h;
						l--;
						h++;
					}else {
						break;
					}
				}
				for(int s=start; s<=end; s++) {
					arr[s]= arr[s] == 0 ? 1:0;
				}
			}
			
		}
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0 && i >0) {
				System.out.println("");
			}
		}
	}

}
