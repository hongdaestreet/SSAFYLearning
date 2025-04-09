package 단일리스트;

public class SinglyLinkedList {
	private Node head;
	private int size;
	
	public SinglyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	// 조회
	public Node get(int idx) {
		// idx가 정상적인지 판단
		if (idx<0||idx>=size) {  // 예외발생
			return null;
		}
		Node curr = head;
		
		// curr 해당 노드를 idx 위치까지 얾기겠다.
		for(int i=0;i<idx;i++) {
			curr = curr.link;
			}
		return curr;
	}
	
	// 노드 추가 (첫번째 위치, 마지막위치, 중간 위치)
	// data가 필요한데 node가 가질 수 있는 데이터
	// node를 파라미터로 가지고 있어도 됨
	public void addFirst(String data) {
		// 1. 노드 생성
		Node node = new Node(data);
		
		// 2. 노드의 링크는 Head
		node.link = head;
		
		// 3. head를 새로 만든 node로 바꿈.
		head = node;
		size++;
	}
	
	// 마지막 노드로 삽입
	public void addLast(String data) {
		if (size==0) {
			addFirst(data);
			return;
		}
		Node node = new Node(data);
		
		Node curr = head;  // 마지막 노드를 찾을 변수
		
		while(curr.link != null) { // 마지막 노드를 찾음. (size만큼 for문 돌려도 됨)
			curr = curr.link;
		}
		curr.link = node;
		size++;
	}
	
	// 중간 노드에 삽입
	public void add(int idx, String data) {
		if (idx<0||idx>size) {  // 범위 초과하면 X
			return;    
		}
		if (idx == 0) {	// idx==0면 가장 앞에 넣고
			addFirst(data);
			return;
		}
		if(idx==size) {	// idx==size면 가장 뒤에 넣음
			addLast(data);
			return;
		}
		
		// 내가 넣고 싶은 위치의 이전 노드를 가져와야 한다
		Node pre = get(idx-1);
		Node node = new Node(data);
		
		// 순서중요
		node.link = pre.link;
		pre.link = node;
		
		size++;
	}
	
	// 삭제(첫번째, 마지막, 중간)
	// 첫번째 삭제
	public String remove() {
		if(head==null) {
			return null;  // 예외발생도 가능
		}
		
		String data = head.data;
		head = head.link;
		size--;
		return data;
	}
	//
	public String remove(int idx) {
		if (idx==0) {
			return remove();
		}
		
		if (idx<0||idx>=size) {  // 범위 벗어나면 X
			return null;
		}
		
		Node pre = get(idx-1);  // 이전 노드

		Node rm = pre.link;  // 삭제 노드 O(1)만에 찾음.  // Node rm = get(idx);은 시간이 꽤 걸림
		
		String data = rm.data;
		
		pre.link = rm.link;  // 이전 link를 삭제노드
		size--;
		return data;
	}
	
	public void printList() {
		Node curr = head;
		
		if (head == null) {
			System.out.println("공백리스트");
			return;
		}
		
		while(curr != null) {
			System.out.print(curr.data+"->");
			curr = curr.link;
		}
		System.out.println();
	}
	
	
	
	
}
