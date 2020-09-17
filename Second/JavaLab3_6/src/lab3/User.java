package lab3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User extends ComplexProfile {
	@Override
	public void register(String login, String password) { // more code
		// qwerty2130
		// y1
		Pattern patternLogin = Pattern.compile("([a-z]{1,16})\\d{1,16}");
		Matcher matcherLogin = patternLogin.matcher(login);
		if (matcherLogin.find()) {
			this.login = login;
		} else {
			System.out.println("user: login is wrong");
		}

		// 123456Aa
		Pattern patternPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
		Matcher matcherPassword = patternPassword.matcher(password);
		if (matcherPassword.find())
			this.password = password;
		else
			System.out.print("user: password is wrong!");
		System.out.print("user created");
	}

	@Override
	public void addMainInformation(String username, String email, String phone) {
		if (!username.isEmpty() && username.length() < 16)
			this.username = username;
		else
			System.out.print("user: username is wrong!");

		// someemail@mail.com
		Pattern patternEmail = Pattern.compile("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
		Matcher matcherEmail = patternEmail.matcher(email);
		if (matcherEmail.find())
			this.email = email;
		else
			System.out.print("user: email is wrong!");

		// +38(044)537-14-28
		// 044 537-1428
		Pattern patternPhone = Pattern.compile(
				"^(?:\\+38)?(?:\\(044\\)[ .-]?[0-9]{3}[ .-]?[0-9]{2}[ .-]?[0-9]{2}|044[ .-]?[0-9]{3}[ .-]?[0-9]{2}[ .-]?[0-9]{2}|044[0-9]{7})$");
		Matcher matcherPhone = patternPhone.matcher(phone);
		if (matcherPhone.find())
			this.phone = phone;
		else
			System.out.print("user: phone is wrong!");
	}

	@Override
	public void addExtraInformation(String fullname, short age, boolean gender, String address) { // more code

		if (fullname.isEmpty())
			this.fullname = fullname;
		else
			System.out.print("user: name is wrong!");

		if (age > 0 && age < 100)
			this.age = age;
		else
			System.out.print("user: age is wrong!");

		this.gender = gender;

		// ssome street 123a
		Pattern patternAddress = Pattern.compile("^([a-zA-Z0-9_ ]+) (\\d+)[ -_+]?(\\w{0,8})");
		Matcher matcherAddress = patternAddress.matcher(address);
		if (matcherAddress.find())
			this.address = address;
		else
			System.out.print("user: address is wrong!");
	}
}
