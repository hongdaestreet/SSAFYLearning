import 단일리스트.SinglyLinkedList;

public class LinkedList02_단일연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();

		list.addFirst("유아름");
		list.printList();

		list.addFirst("문하은");
		list.printList();

		list.addLast("이유리");
		list.printList();

		list.add(1, "이정은");
		list.printList();

		list.remove();
		list.printList();
		
		list.remove(1);
		list.printList();
	}
}
