import 단일리스트.SinglyLinkedList;

public class LL02_단일연결리스트 {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		
		list.addFirst("AA");
		list.printList();
		
		list.addFirst("BB");
		list.printList();
		
		list.addLast("CC");
		list.printList();
		
		
		list.add(1, "AA");
		list.printList();
		
		list.remove();
		list.printList();
		list.remove(1);
		list.printList();
		
	}

}
