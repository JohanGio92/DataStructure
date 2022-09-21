package factorymethod;

public class FactoryMethodApp {

	public static void main(String[] args) {
		
		Factory<ConcreteA> factory = new Factory<>(ConcreteA.class);
		ConcreteA concreteA = factory.create();
		concreteA.toDo();
	}

}
