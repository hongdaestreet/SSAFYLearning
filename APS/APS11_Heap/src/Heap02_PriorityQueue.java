import java.util.PriorityQueue;

public class Heap02_PriorityQueue {
	public static void main(String[] args) {
		// 최소 힙이 기본 값임
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(10);
		pq.add(25);
		pq.add(20);
		pq.add(19);
		pq.add(34);

		System.out.println(pq);
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());

		// 비교 기준 넣으면 최대힙으로 바꿀 수 있음 -> 음수 기호 붙이면 됨
		PriorityQueue<Integer> pqMax = new PriorityQueue<>();
		
		
		pqMax.add(-10);
		pqMax.add(-25);
		pqMax.add(-20);
		pqMax.add(-19);
		pqMax.add(-34);

		System.out.println(pqMax);
		System.out.println(-pqMax.poll());  // 뺄때도 음수붙여야 함
		System.out.println(-pqMax.poll());
		System.out.println(-pqMax.poll());
		
		
	}

}
