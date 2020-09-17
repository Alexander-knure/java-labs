package lab3;

public class UnencryptedAccountFactory extends AbstractProfileFactory {
	   public SimpleProfile createSimpleProfile() {
	        return new Visitor();
	   }
	    public ComplexProfile createComplexProfile() {
	        return new User();
	   }
	}

