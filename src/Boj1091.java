import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1091 {
    static int [] swap;
    static Card [] deck;
    static int n;
    static class Card{
        int i;
        int goal;

        public Card(int i, int goal) {
            this.i = i;
            this.goal = goal;
        }

        @Override
        public String toString() {
            return "Card{" +
                    "i=" + i +
                    ", goal=" + goal +
                    '}';
        }
    }

    public static boolean dispenseCard(){
        for(int i=0; i<n; i++){
            if(deck[i].goal!=i%3){
                return false;
            }
        }
        return true;
    }
    public static void swapCard(){
        Card [] temp = new Card[n];
        for(int i=0; i<n; i++){
            temp[swap[i]] = deck[i];
        }
        deck = temp;
    }

    public static boolean checkCycle(){
        for(int i=0; i<n; i++){
            if(i != deck[i].i){
                return false;
            }
        }
        return true;
    }

    public static int startGame(){
        //먼저 분배
        // 아니라면 섞기
        // 다시 분배
        // 아니라면 다시 섞기
        // 만약 섞었던 것과 동일한 카드 배열이 일어난다면, 무한순환이 되고 있는 것이니까 불가능한 경우로 처리
        boolean fin = false;
        int cnt =0;
        do {
            fin = dispenseCard();
            if(!fin){
                cnt++;
                swapCard();
                if(checkCycle()){
                    break;
                }
            }
        }while (!fin);

        if(!fin){
            return -1;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        swap = new int [n];
        deck = new Card[n];
        for(int i=0; i<n; i++){
            deck[i]=new Card(i,Integer.parseInt(st.nextToken()));
        }
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            swap[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(startGame());
    }
}
