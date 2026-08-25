package heap;

import java.util.Arrays;

public class HeepMain {
	public static void main(String[] args) {
		Heap<Integer> heep = new Heap<>();
		
		heep.add(10);
		heep.add(3);
		heep.add(23);
		heep.add(44);
		heep.add(19);
		heep.add(35);
		heep.add(47);
		heep.add(80);
		heep.add(35);
		heep.add(60);
		
		System.out.println(heep.peek());
		System.out.println(Arrays.toString(heep.toArray()));
		
		System.out.print(heep.remove() + " " + heep.remove() + " " + heep.remove() + " ");
		System.out.print(heep.remove() + " " + heep.remove() + " " + heep.remove() + " ");
		System.out.print(heep.remove() + " " + heep.remove() + " " + heep.remove() + " " + heep.remove());
		
	}
}
