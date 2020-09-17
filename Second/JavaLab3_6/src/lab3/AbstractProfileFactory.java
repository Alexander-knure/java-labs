package lab3;

public abstract class AbstractProfileFactory {
	
	//Profile -> object
	public abstract SimpleProfile createSimpleProfile();

	public abstract ComplexProfile createComplexProfile();

}
