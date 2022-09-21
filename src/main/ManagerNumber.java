package main;

import java.util.List;

public class ManagerNumber {
	
	private List<? extends Number> numbers;
	
	public ManagerNumber(List<? extends Number> numbers) {
		setNumbers(numbers);
	}
	
	public void setNumbers(List<? extends Number> numbers) {
		this.numbers = numbers;
	}
	
	public void display() {
		for (Number number : numbers) {
			System.out.println(number.doubleValue());
		}
	}
}
