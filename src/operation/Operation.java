package operation;

interface Operation<T extends Number> {
	
	Number execute(Number number, Number otherNumber);
}
