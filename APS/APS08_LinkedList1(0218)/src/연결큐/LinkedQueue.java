package 연결큐;

public class LinkedQueue {
	public Node front;
	public Node rear;

	// 삽입
	public void enQueue(int data) {
		// 새로운 노드 생성
		Node node = new Node(data);
		// front, rear 하나가 널이면 공백 큐
		if (front == null) {
			front = rear = node;
		} else {
			rear.link = node;
//			rear= rear.link;
			rear = node;
		}
	}

	// 삭제
	public int deQueue() {
		if (front != null) {
			int data = front.data;
			front = front.link;
			return data;
		}

		return -1; // 고민이 필요하다
	}

}
