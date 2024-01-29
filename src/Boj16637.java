import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj16637 {
    static ArrayList<Integer> numArr = new ArrayList<>();
    static ArrayList<Character> opArr = new ArrayList<>();
    static int n;
    static int max=Integer.MIN_VALUE;
    static void dfs(int nth, int sum){
        if(nth == opArr.size()){
            max = Math.max(max,sum);
            return;
        }
        dfs(nth+1,cal(sum,numArr.get(nth+1),opArr.get(nth)));
        if(nth+2 <= opArr.size()){
            dfs(nth+2,cal(sum,cal(numArr.get(nth+1) ,numArr.get(nth+2),opArr.get(nth+1)),opArr.get(nth)));
        }
    }

    static int cal(int a , int b, char op){
        if(op=='+'){
            return a+b;
        }
        else if(op=='-'){
            return a-b;
        }
        else {
            return a*b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String exp = br.readLine();

        for(char c : exp.toCharArray()){
            if(Character.isDigit(c)){
                numArr.add(c-'0');
            }
            else{
               opArr.add(c);
            }
        }

        dfs(0,numArr.get(0));
        System.out.println(max);

    }
}
