package lab3;

public abstract class ComplexProfile {
	String username;
	String login;
	String password;
	String email;
	String phone;

	String fullname;
	short age;
	boolean gender;
	String address;

	abstract void register(String login, String password);
	abstract void addMainInformation(String username, String email, String phone);
	abstract void addExtraInformation(String fullname, short age, boolean gender, String address);

	// метод восстановления данных
	// abstract void recovery();

}
