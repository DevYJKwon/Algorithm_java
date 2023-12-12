import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Swea5607{
    public static final int p = 1234567891;

    static long divPow(long num, long n) {
         
        if(n==0) {
            return 1;
        }
         
        long res = divPow(num,n/2);
         
        if(n%2==0) {
            return (res*res)%p;
        }
        else {
            return ((res*res)%p*num)%p;
        }
    }
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        long [] fac = new long [1000001];
        fac[0]=1;
        fac[1]=1;
        for(int i=2; i<=1000000; i++) {
        	fac[i]= (fac[i-1]*i)%p;
        }
        
        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            sb.append("#").append(t).append(" ");
            sb.append(((fac[n]*divPow((fac[n-r]*fac[r])%p,p-2))%p)).append("\n");
        }
        System.out.println(sb);
    }
 
}