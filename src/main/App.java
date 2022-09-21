package main;

import java.util.LinkedList;
import java.util.List;

import operation.Numeration;
import operation.Summation;

public class App {

	public static void main(String[] args) {
		
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i <= 10; i++) {
			list.add(i);
		}
		
		ManagerNumber managerNumber = new ManagerNumber(list);
		managerNumber.display();
			
		List<Double> listDouble = new LinkedList<>();
		for (double i = 0; i <= 10; i++) {
			System.out.println(i/10);
			listDouble.add(i/10);
		}
		
		Summation<Number> sumation = new Summation<>();
		Numeration<? extends Number> entero = sumation.createNumeration(4, 2);
		System.out.println(entero.getValue1());
		
	}

}
