import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1195 {
    public static int engage(int start,String gear1, String gear2){
        int len = 0;
        int last =start;
        for(int i=start; i < gear1.length(); i++){
            if(gear1.charAt(i) == '2'&&gear1.charAt(i) == gear2.charAt(len)){
                return Integer.MAX_VALUE;
            }
            len++;
            if(len == gear2.length()){
                last += (gear1.length()-(start+len));
                break;
            }
        }
        len += (gear2.length() - len);
        len+=last;
        return len;
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] gears = new String[2];
        gears[0]= br.readLine();
        gears[1]=br.readLine();
        int min = gears[0].length()+gears[1].length();

        for(int i=0; i<gears[0].length(); i++){
            min = Integer.min(min,engage(i,gears[0],gears[1]));
        }
        for(int i=0; i<gears[1].length(); i++){
            min = Integer.min(min,engage(i,gears[1],gears[0]));
        }

        System.out.println(min);
    }
}
