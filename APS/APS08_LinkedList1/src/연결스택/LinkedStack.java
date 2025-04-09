package 연결스택;

public class LinkedStack {
	public Node top; // 포인터 변수가 한 개 필요

	// 삽입
	public void push(int data) {
		Node node = new Node(data); // 새로운 노드 생성
		node.link = top; // top이 가리키는 주소 넣기
		top = node; // 이제 top은 새로운 노드
	}

	// 삭제
	public int pop() {
		if (top == null) { // 비어있으면 실행X
			return -1;
		}
		int data = top.data; // 삭제할 데이터 보관
		top = top.link; // top 바로 밑 데이터가 top이 됨
		return data;
	}

	// 조회
	public int peek() {
		if (top == null)
			return -1; // 비어있으면 실행X
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
