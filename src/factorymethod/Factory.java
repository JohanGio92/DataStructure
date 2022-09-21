package factorymethod;

public class Factory<T extends AbstractClass> {

	private T instance;
	
	public Factory(Class<T> clazz) {
		try {
			instance = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public T create() {
		return instance;
	}
}
