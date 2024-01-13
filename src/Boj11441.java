import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n; i++){
            arr[i]= arr[i-1]+Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(arr[end]-arr[start-1]).append("\n");
        }
        System.out.println(sb);
    }
}
