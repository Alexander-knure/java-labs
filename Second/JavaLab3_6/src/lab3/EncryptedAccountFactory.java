package lab3;

public class EncryptedAccountFactory extends AbstractProfileFactory {
	public SimpleProfile createSimpleProfile() {
		return new Master();
	}

	public ComplexProfile createComplexProfile() {
		return new Admin();
	}
}
