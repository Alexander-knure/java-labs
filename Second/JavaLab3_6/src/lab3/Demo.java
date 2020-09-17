package lab3;

public class Demo {
	private static Application configureClient(boolean isEncrypt) {
		Application app;
		AbstractProfileFactory factory;

		if (isEncrypt) {
			factory = new EncryptedAccountFactory();
			app = new Application(factory);
		} else {
			factory = new UnencryptedAccountFactory();
			app = new Application(factory);
		}
		return app;
	}

	public static void main(String[] args) {
		String[] logins = { "Alex", "Vladimir", "Natali", "Ivan" };
		String[] passwords = { "Qwerty123*", "UIop_0001", "NUREua(2020)", "javaFactory->1999" };

		Application app1 = configureClient(true);
		app1.create(logins[0], passwords[0], logins[1], passwords[1]);

		Application app2 = configureClient(false);
		app2.create(logins[2], passwords[2], logins[3], passwords[3]);
		
	}
}
