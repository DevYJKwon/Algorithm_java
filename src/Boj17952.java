import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

class Task { // 업무를 정의할 클래스
	int score; // 업무의 점수
	int time; // 엄무의 남은 시간

	public Task(int score, int time) { // 생성자
		this.score = score; // 업무의 점수 초기화
		this.time = time; // 업무의 시간 초기화
	}

}

public class Boj17952 {

	public static void main(String[] args) throws IOException { // br.readLine 도중 발생할 수 있는 입출력 예외처리
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 1줄 입력을 받을 bufferedReader 생성
		int n = Integer.parseInt(br.readLine()); // 한 줄을 입력 받고 int로 변환하여 저장
		Stack<Task> stack = new Stack<>(); // 스택 생성
		long score = 0; // 총 점수를 저장할 변수
		StringTokenizer st; // 한 줄에 공백으로 구분된 문자들을 토큰으로 입력 받기 위해 선언
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine()); // 한 줄에 공백으로 구분된 문자들을 토큰으로 입력 받음.
			int type = Integer.parseInt(st.nextToken());
			if (type == 1) { // 타입이 1이라면 업무가 있다는 뜻
				int a = Integer.parseInt(st.nextToken()); // 해당 업무의 점수
				int t = Integer.parseInt(st.nextToken()); // 해당 업무의 시간
				stack.add(new Task(a, t)); // task객체로 만들어서 스택에 삽입

			}
			if(!stack.isEmpty()) {
				Task current = stack.pop(); // 스택 가장 위에 있는 task를 꺼냄
				current.time--; // 시간 감소
				if (current.time == 0) { // 다 끝났다면
					score += current.score; // 총합에 점수를 더함
				} else { // 끝내지 못했다면
					stack.add(current); // 스택에 다시 삽입
				}
			}
		}

		System.out.println(score); // 총합 출력
	}

}
