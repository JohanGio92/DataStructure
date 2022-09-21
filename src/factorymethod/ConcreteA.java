package factorymethod;

public class ConcreteA extends AbstractClass {

	@Override
	public void toDo() {
		System.out.println(ConcreteA.class.getSimpleName());
	}

}
