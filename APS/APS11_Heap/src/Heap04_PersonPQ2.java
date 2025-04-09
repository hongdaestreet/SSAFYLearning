import java.util.Comparator;
import java.util.PriorityQueue;

class Person {
	String name;
	int age;

	public Person() {
		this("김싸피", 13);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class Heap04_PersonPQ2 {

	public static void main(String[] args) {
//		PriorityQueue<Person> pq = new PriorityQueue<>();
		PriorityQueue<Person> pqAge = new PriorityQueue<>(new AgeComparator());  // 나이 순서
		PriorityQueue<Person> pqName = new PriorityQueue<>(new NameComparator());  // 나이 순서
		
		PriorityQueue<Person> pqPerson = new PriorityQueue<>(new Comparator<Person>() {
			// 나이순
			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o2.age-o1.age;
			}
			
		});
		
		// 람다 표현식: 함수를 간결하게 표현
		// 자바에서 함수는 독립적으로 존재X
		// 파라미터가 단일이면 () 생략 가능
		// body가 단일 문장이면 {} 생략 가능
		
		PriorityQueue<Person> pq = new PriorityQueue<>((o1,o2)->{
			if (o1.name.equals(o2.name)) {
				return o1.age-o2.age;
			}else {
				return o1.name.compareTo(o2.name);
			}
		});
		
		pq.add(new Person("4등", 25));
		pq.add(new Person("1등", 46));
		pq.add(new Person("3등", 27));
		pq.add(new Person("2등", 29));
		
		System.out.println(pq.poll());
	}

}
