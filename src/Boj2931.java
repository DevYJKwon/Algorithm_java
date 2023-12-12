import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2931 {
	static char[][] map; //맵을 저장할 2차원 배열
	static Point res; // 결과의 위치를 저장할 포인트 변수
	static char resPart; // 결과의 도로를 저장할 변수
	static int r, c, b; // 행, 열, 블록 수를 저장할 변수
	static boolean isSuc; // 성공했는지 여부를 확인하는 플래그 변수
	
	static boolean isIn(int x, int y) { //해당 좌표가 맵 안에 있는지 확인
		if(x >=0 && y >=0 && x < c && y < r) { // x,y가 0보다 크고 c,r보다 작다면
			return true; // 안에 있는거니 true
		}
		return false; //아니면 밖이니 false
	}
	
	static void dfs(int x, int y, int t, char head) { //dfs 탐색
		if(!isIn(x,y)) { // 맵 안에 없다면 
			return; // 종료
		}
		if (map[y][x] == 'Z') { // Z에 도착했다면
			if (t == b) { // 블록을 모두 사용했다면
				isSuc = true; // 성공
			}
			return; //종료
		}
		else if(t > b) { // 넘었다면
			return; // 실패
		}

		switch (map[y][x]) { // 현재 맵의 도로의 종류를 파악
		case '|': // 상하 도로면
			if (head == 'U') { // 위에서 왔을 경우
				dfs(x, y - 1, t + 1, 'U'); // 위로
			} else if (head == 'D') { // 아래서 왔을 경우
				dfs(x, y + 1, t + 1, 'D'); // 아래로
			}
			break;//스위치문 브레이크
		case '-': // 좌우
			if (head == 'L') { // 좌측에서 옴
				dfs(x - 1, y, t + 1, 'L'); // 좌로
			} else if (head == 'R') { // 우측에서 옴
				dfs(x + 1, y, t + 1, 'R'); // 우로
			}
			break; // 스위치문 브레이크
		case '+': // 십자
			if (head == 'U') { // 위에서 온게 아니라면
				dfs(x, y-1, t + 1, 'U'); // 아래
			}
			else if (head == 'R') { //우에서 온게 아니라면
				dfs(x + 1, y, t + 1, 'R'); //좌로
			}
			else if (head == 'L') { //좌에서 온게 아니라면
				dfs(x - 1, y, t + 1, 'L');
			}
			if (head == 'D') { // 아래에서 온게 아니라면
				dfs(x, y+1, t + 1, 'D'); //위
			}
			break; // 브레이크
		case '1': // 1번도로
			if (head == 'U') { // 위에서 왔으며ㅑㄴ
				dfs(x + 1, y, t + 1, 'R'); // 우측
			} else if (head == 'L') { // 좌측에서 오면
				dfs(x, y + 1, t + 1, 'D'); // 아래
			}
			break; // 브레이크
		case '2': // 2번 도로
			if (head == 'D') { // 아래에서 오면
				dfs(x +1, y, t + 1, 'R'); // 좌측
			} else if (head == 'L') { // 좌측에서 오면
				dfs(x, y - 1, t + 1, 'U'); // 위로
			}
			break; //브레이크

		case '3': // 3번 도로
			if (head == 'R') { // 우측에서 오면
				dfs(x, y - 1, t + 1, 'U'); // 위로
			} else if (head == 'D') { // 아래에서 오면
				dfs(x - 1, y, t + 1, 'L'); // 좌측으로
			}
			break; // 브레이크
		case '4': // 4번 도로
			if (head == 'U') { // 위에서 오면
				dfs(x - 1, y, t + 1, 'L'); //좌측 
			} else if (head == 'R') { // 우측에서 오면
				dfs(x, y + 1, t + 1, 'D'); // 아래
			}
			break; // 브레이크
		}
	}

	public static void main(String[] args) throws IOException { // br.readLine 도중 발생할 수 있는 입출력 예외처리
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 1줄 입력을 받을 bufferedReader 생성
		StringTokenizer st; // 한 줄에 공백으로 구분된 문자들을 토큰으로 입력 받기 위해 선언
		Point start = null; // 시작점을 저장할 Point 변수
			st = new StringTokenizer(br.readLine()); // 한 줄 입력
			r = Integer.parseInt(st.nextToken()); // 행 입력
			c = Integer.parseInt(st.nextToken()); // 열 입력
			map = new char[r][c]; // 맵 저장
			b = 0; // 총 도로의 수를 저장할 변수
			for (int y = 0; y < r; y++) { // 행 만큼 순회
				String str = br.readLine(); // 한 줄 입력
				for (int x = 0; x < c; x++) { // 열 만큼 순회
					map[y][x] = str.charAt(x); // str의 char 입력을 받음
					if (map[y][x] == 'M') { // 출발지라면
						start = new Point(x, y); // 위치 저장
					}
					if (map[y][x] != 'M' && map[y][x] != 'Z' && map[y][x] != '.') { //도로라면
						if(map[y][x]=='+') {
							b++;
						}
						b++; // 도로 개수 증가
					}
				}
			}
			b+=2;
			char[] roads = { '|', '-', '+', '1', '2', '3', '4' }; // 도로 모음
			int[] dx = { 1, 0, 0, -1 }; // x로 움직일 수 있는 경우
			int[] dy = { 0, 1, -1, 0 }; // y로 움직일 수 있는 경우
			for (int y = 0; y < r; y++) { // 행만큼 순회
				for (int x = 0; x < c; x++) { // 열만큼 순회
					if (map[y][x] == '.') { // 빈 곳이라면
						for (int i = 0; i < 7; i++) { // 도로 모음 만큼 순회
							for (int d = 0; d < 4; d++) { //움직일 수 있는 방향만큼 순회
								map[y][x] = roads[i]; // 도로를 넣어본다
								if(roads[i]=='+') {
									b++;
								}
								int nx = dx[d] + start.x; // 새롭게 위치 선정
								int ny = dy[d] + start.y; // 새롭게 위치 선정
								if (nx >= 0 && ny >= 0 && nx < c && ny < r) { // 맵 안에 있는지 체크
									if(d==0) { // 0번이라면
										dfs(nx, ny, 1, 'R'); // 좌측 방향에서 옴
									}
									else if(d==1) { // 1번이라면
										dfs(nx, ny, 1, 'D'); // 위에서 옴
									}
									else if(d==2) { // 2번이라면
										dfs(nx, ny, 1, 'U'); // 아래에서 옴
									}
									else { // 3번이라면
										dfs(nx, ny, 1, 'L'); // 우측에서 옴
									}	
									if(isSuc) { // 성공했다면
										res = new Point(x,y); // 결과 저장
										resPart = roads[i]; // 도로 저장
										System.out.println(String.format("%d %d %c", res.y+1,res.x+1,resPart)); // 결과 저장
										return;
									}
									else {
										map[y][x]='.'; // 실패라면 다시 복구
										
									}
								}
								if(roads[i]=='+') {
									b--;
								}
							}
						}
					}
				}
			}
	}

}
