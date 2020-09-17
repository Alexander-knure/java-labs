package lab3;

public abstract class SimpleProfile {
	String status;
	String login;
	String password;
	abstract void register(String login, String password);
}
