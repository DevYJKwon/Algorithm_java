import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj31423 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String [] arr = new String[n];
        for(int i=0; i<n; i++){
            arr[i] = br.readLine();
        }
        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            StringBuilder sb = new StringBuilder();
            arr[from] = sb.append(arr[from]).append(arr[to]).toString();
        }
        for(int i=0; i<n; i++){
            System.out.println(arr[i]);
            break;
        }
    }
}
