package 단일리스트;

//데이터필드, 링크(다음)필드
public class Node {
	//데이터 필드 String 으로 고정했지만.... <추후 심화를 통해 T 제네릭으로 바꾸어보시오
	public String data;
	//Node 라고 하는 다음 주소를 저장하겠다
	public Node link;
	
	//아래의 기본생성자를 생성하지 않으면..
	public Node() {
	}
	
	public Node(String data) {
		this.data = data;
		this.link = null; //참조자료형은 어차피 기본 값은 null로 초기화
	}
}
