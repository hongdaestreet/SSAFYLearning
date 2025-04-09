package 단일리스트;

public class SinglyLinkedList {
	private Node head; // 연결리스트의 시작점
	private int size;

	public SinglyLinkedList() {
		// 없어도 괜찮아!
		this.head = null;
		this.size = 0;
	}

	// 조회
	public Node get(int idx) {
		// idx가 정상적인지를 판단
		if (idx < 0 || idx >= size) {
			// 예외발생 시킬 수도 있음
			// idx < 0 : 그냥 0번인덱스
			// idx >= size : 마지막 인덱스
			return null;
		}
		Node curr = head;
		// curr 해당 노드를 idx 위치까지 옮기겠다.
		for (int i = 0; i < idx; i++) {
			curr = curr.link;
		}

		return curr;
	}

	// 노드를 추가 (첫번째위치, 마지막위치, 중간위치)
	// data가 필요한데 Node가 가질 수 있는 데이터
	// Node를 파라미터로 가지고 있어도 가넝
	public void addFirst(String data) {
		// 1. 노드를 생성한다.
		Node node = new Node(data);
		// 2. 노드의 링크는 head
		node.link = head;
		// 3. head를 새로 만든 node로 바꾼다.
		head = node;
		size++;
	}

	public void addLast(String data) {
		if (size == 0) {
			addFirst(data);
			return;
		}
		Node node = new Node(data);

		Node curr = head; // 마지막 노드를 찾을 변수

		// 마지막 노드를 찾아가자! (size 만큼 for문을 돌려도 가넝)
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = node;
		size++;
	}

	public void add(int idx, String data) {
		if (idx < 0 || idx > size) {
			// 앞의 상황이면 가장 앞에 넣을거고
			// 뒤의 상황이면 가장 뒤에 넣겠다
			return; // 너무 벗어났을 때 안해!
		}
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx == size) {
			addLast(data);
			return;
		}

		// 내가 넣고 싶은 위치의 이전노드를 가져와야한다.
		Node pre = get(idx - 1);

		Node node = new Node(data);

		// 순서중요
		node.link = pre.link;
		pre.link = node;

		size++;
	}

	// 삭제(첫번째 위치 삭제, 마지막 위치 삭제, 중간 위치 삭제)
	public String remove() {
		if (head == null) {
			// 예외발생도 가능!
			return null;
		}

		String data = head.data;
		head = head.link;
		size--;
		return data;
	}

	public String remove(int idx) {
		if (idx == 0)
			return remove();

		// 범위를 벗어났으면..
		if (idx < 0 || idx >= size)
			return null;

		Node pre = get(idx - 1); // 이전노드
//		Node rm = get(idx);	   //삭제노드
		Node rm = pre.link; // O(1)

		String data = rm.data;
//		String data = pre.link.data; 

		pre.link = rm.link;// 삭제노드 이전의 링크를 삭제노드링크로 연결
//		pre.link = pre.link.link;
		size--;
		return data;
	}

	public void printList() {
		Node curr = head;

		if (head == null) {
			System.out.println("공백리스트야 미안훼!");
			return;
		}

		while (curr != null) {
			System.out.print(curr.data + "->");
			curr = curr.link;
		}

		System.out.println();
	}

}
