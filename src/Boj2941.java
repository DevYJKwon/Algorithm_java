import java.io.*;
import java.util.*;
public class Boj2941 {

    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String [] list = {"dz=","c=","c-","d-","lj","nj","s=","z="};


        for(String s : list){
            str = str.replace(s,"1");
        }
        HashSet<Integer> set = new HashSet<>();
        Integer [] arr = (Integer [])set.toArray();
        System.out.println(str.length());
    }
}
