import java.util.PriorityQueue;

//class Person implements Comparable<Person> {
//	String name;
//	int age;
//
//	public Person() {
//		this("김싸피", 13);
//	}
//
//	public Person(String name, int age) {
//		this.name = name;
//		this.age = age;
//	}
//
//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + "]";
//	}
//
//	@Override
//	public int compareTo(Person o) { // 이름 순 정렬
//		// 내림차순
////		return this.age - o.age;
////		 이름순
//		return this.name.compareTo(o.name);
//	}
//
//}

public class Heap03_PersonPQ1 {

	public static void main(String[] args) {
		PriorityQueue<Person> pq = new PriorityQueue<>();

		pq.add(new Person("4등", 25));
		pq.add(new Person("1등", 46));
		pq.add(new Person("3등", 27));
		pq.add(new Person("2등", 29));
		
		System.out.println(pq.poll());
	}

}
