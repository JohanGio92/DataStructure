package linkedListComposite;

public class AppList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>(10);
		
		list.add(5);
		list.add(4);
		list.add(10);
		list.add(20);
		list.display();
		System.out.println("size: " + list.size());
		System.out.println(list.has(11));
		System.out.println(list.get(4));
	}

}
