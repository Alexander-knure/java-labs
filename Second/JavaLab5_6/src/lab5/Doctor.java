package lab5;

public class Doctor extends Human {
	Doctor(String name, String surname, String patronymic, String phone, String address) {
		super(name, surname, patronymic, phone, address);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return getSurname() + ' ' + getName() + ' ' + getPatronymic() + '\n' + "тел. " + getPhone() + "\n" + "адрес "
				+ getAddress();
	}

	private String DoStamp() {
		return "ВРАЧ\n" + getSurname() + ' ' + getName().charAt(0) + '.' + getPatronymic().charAt(0) + '.';
	}
}
