package 연결스택;

public class Node {
	public int data;  // 데이터
	public Node link;  // 스택 바로 밑 원소의 주소(다음 주소)
	
	public Node(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}
