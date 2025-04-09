package 단일리스트;
public class Node {
	// T 컬렉션으로도 설정할 수 있음
	public String data;
	public Node link;  // 다음 주소 저장
	
	public Node(String data) {
		this.data = data;
		this.link = null;  // 참조자료형 기본 값 -> null
	}
	
}
