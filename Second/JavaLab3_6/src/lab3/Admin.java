package lab3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Admin extends ComplexProfile {

	@Override
	public void register(String login, String password) { // more code
		// qwerty2130
		// y1
		Pattern patternLogin = Pattern.compile("([a-z]{1,16})\\d{1,16}");
		Matcher matcherLogin = patternLogin.matcher(login);
		if (matcherLogin.find()) {
			this.login = login;
		} else {
			System.out.println("admin: login is wrong");
		}

		// 123456Aa
		Pattern patternPassword = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$");
		Matcher matcherPassword = patternPassword.matcher(password);
		if (matcherPassword.find())
			this.password = encode(password, "admin");
		else
			System.out.println("admin: password is wrong!");
		
		System.out.println("admin created");
	}

	@Override
	public void addMainInformation(String username, String email, String phone) {
		if (!username.isEmpty() && username.length() < 16)
			this.username = username;
		else
			System.out.println("admin: username is wrong!");

		// someemail@mail.com
		Pattern patternEmail = Pattern.compile("\\b[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,4}\\b");
		Matcher matcherEmail = patternEmail.matcher(email);
		if (matcherEmail.find())
			this.email = email;
		else
			System.out.println("admin: email is wrong!");

		// +38(044)537-14-28
		// 044 537-1428
		Pattern patternPhone = Pattern.compile(
				"^(?:\\+38)?(?:\\(044\\)[ .-]?[0-9]{3}[ .-]?[0-9]{2}[ .-]?[0-9]{2}|044[ .-]?[0-9]{3}[ .-]?[0-9]{2}[ .-]?[0-9]{2}|044[0-9]{7})$");
		Matcher matcherPhone = patternPhone.matcher(phone);
		if (matcherPhone.find())
			this.phone = phone;
		else
			System.out.println("admin: phone is wrong!");
	}

	@Override
	public void addExtraInformation(String fullname, short age, boolean gender, String address) { // more code

		if (fullname.isEmpty())
			this.fullname = fullname;
		else
			System.out.println("admin: name is wrong!");

		if (age > 0 && age < 100)
			this.age = age;
		else
			System.out.println("admin: age is wrong!");

		this.gender = gender;

		// ssome street 123a
		Pattern patternAddress = Pattern.compile("^([a-zA-Z0-9_ ]+) (\\d+)[ -_+]?(\\w{0,8})");
		Matcher matcherAddress = patternAddress.matcher(address);
		if (matcherAddress.find())
			this.address = address;
		else
			System.out.println("admin: address is wrong!");
	}

	private String encode(String pText, String pKey) {
		byte[] txt = pText.getBytes();
		byte[] key = pKey.getBytes();
		byte[] res = new byte[pText.length()];

		for (int i = 0; i < txt.length; i++)
			res[i] = (byte) (txt[i] ^ key[i % key.length]);

		return String.valueOf(res);
	}

	private String decode(byte[] pText, String pKey) {
		byte[] res = new byte[pText.length];
		byte[] key = pKey.getBytes();

		for (int i = 0; i < pText.length; i++) {
			res[i] = (byte) (pText[i] ^ key[i % key.length]);
		}
		return new String(res);
	}
}
