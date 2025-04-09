import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack05_뒤로앞으로 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<String> back = new Stack<>();
		Stack<String> front = new Stack<>();
		
		String page = "구글";
	while (true) {
		System.out.println("1.새로운 페이지 방문");
		System.out.println("2.뒤로가기");
		System.out.println("3.앞으로가기");
		System.out.println("0.종료 (1,2,3 제외)");
		
		int N = Integer.parseInt(br.readLine());
		switch (N) {
		case 1:
			// 새 페이지 방문
			// 1. 현재 페이지를 back 스택에 넣음
			back.push(page);
			// 2. 새로운 페이지를 입력받기
			page = br.readLine();
			// 3. 앞으로 스택 비워야 함
			// 3-1. while,for문 이용하여 공백상태가 될때까지 뽑기
			// 3-2. 새로운 스택 생성
			// 3-3. clear() 메서드 활용해서 비우기
			front.clear();
			// 4. 현재페이지 출력(선택)
			System.out.println("현재 페이지 : "+page);
			break;
			
		case 2:
			// 뒤로가기 기능
			if(back.isEmpty()) {
				System.out.println("버튼 비활성화");
			}else {
				// 1. 현재 페이지를 앞으로 스택에 넣음
				front.push(page);
				// 2. 현재 페이지는 뒤로 가기에서 꺼내오기
				page = back.pop();
				// 3. 출력한다.
				System.out.println("현재 페이지 : "+page);
			}
			break;
		case 3:
			// 앞으로 가기 기능
			if (front.isEmpty()) {
				System.out.println("비활성화 상태");
			}else{
				// 1. 현재 페이지를 뒤 스택에 넣는다.
				back.push(page);
				// 2. 앞 스택에서 꺼내어 현재 페이지에 넣는다.
				page = front.pop();
				// 3. 출력한다.
				System.out.println("현재 페이지 : "+page);
			}
			
			break;
			default:
				System.out.println("종료");
				return;
		}
		
		
	}
		
	}
}
