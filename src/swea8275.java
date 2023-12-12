import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea8275 {
 
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static int T;
    static int N, X, M;
    static Info[] infos;
 
    static int MAX;
    static int[] MAX_CHOICE;
 
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            tokens = new StringTokenizer(input.readLine());
            N = Integer.parseInt(tokens.nextToken());// (1 ≤ N ≤ 6) 우리 수
            X = Integer.parseInt(tokens.nextToken());// 1 ≤ X, M ≤ 10 우리 당 햄스터 수
            M = Integer.parseInt(tokens.nextToken());// 1 ≤ X, M ≤ 10 기록의 수
 
            infos = new Info[M];
            for (int m = 0; m < M; m++) {
                tokens = new StringTokenizer(input.readLine());
                // 1base index
                int l = Integer.parseInt(tokens.nextToken());
                int r = Integer.parseInt(tokens.nextToken());
                int s = Integer.parseInt(tokens.nextToken());
                infos[m] = new Info(l, r, s);
            }
 
            MAX = Integer.MIN_VALUE;
            MAX_CHOICE = null;
            // 우리의 개수도 1인덱스 사용중, 누적도 역시 따라감.
            makePermutation(1, new int[N + 1], new int[N + 1]);
 
            output.append("#").append(t).append(" ");
            if (MAX == Integer.MIN_VALUE) {
                output.append(-1);
            } else {
                for (int i = 1; i < MAX_CHOICE.length; i++) {
                    output.append(MAX_CHOICE[i]).append(" ");
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }
 
    /**
     * 햄스터의 마리순서가 의미가 있음 - 순열, 마리수는 중복될 수 있음 - 중복 순열
     * 
     * @param nthChoice
     *            몇 번까지 선택되었나요?
     * @param choosed
     *            선택된 녀석들의 정보를 가지고 다닐 배열
     * @param accums
     *            누적합을 가지고 다닐 배열
     */
    static void makePermutation(int nth, int[] choosed, int[] accums) {
 
        if (nth == choosed.length) {
            //System.out.println(Arrays.toString(choosed) +" : "+Arrays.toString(accums));
            if (accums[N] > MAX) {
                MAX = accums[N];
                MAX_CHOICE = choosed.clone();
            }
            return;
        }
        // 0마리 부터 X 마리까지 가능
        for (int x = 0; x <= X; x++) {
            choosed[nth] = x;
            accums[nth] = accums[nth - 1] + x;
            // 여기까지 만들어진 순열은 타당한가? 타당하면 다음으로 가기
            if (check(nth, accums)) {
                makePermutation(nth + 1, choosed, accums);
            }
        }
    }
 
    // 하나라도 부합하지 않으면 실패
    static boolean check(int nth, int[] accums) {
        for (int m = 0; m < M; m++) {
            Info info = infos[m];
            if (!info.isOk(nth, accums)) {
                return false;
            }
        }
        return true;
    }
 
    static class Info {
        int l;
        int r;
        int s;
 
        public Info(int l, int r, int s) {
            this.l = l;
            this.r = r;
            this.s = s;
        }
 
        public boolean isOk(int nth, int[] accums) {
            // 아직 체크하려는 범위가 오지 않았다면 통과~~~
            if (this.r > nth) {
                return true;
            } 
            // 아니면 이 영역의 합이 누적 합이 s와 같은지 판단
            else if (this.s == (accums[r] - accums[l - 1])) {
                return true;
            }
            return false;
        }
    }
 
    // REMOVE_START
    private static String src = "3\r\n" +
            "3 5 1\r\n" +
            "1 2 5\r\n" +
            "3 5 2\r\n" +
            "1 2 6\r\n" +
            "2 3 7\r\n" +
            "4 5 2\r\n" +
            "1 3 15\r\n" +
            "3 4 4";
    // REMOVE_END
}