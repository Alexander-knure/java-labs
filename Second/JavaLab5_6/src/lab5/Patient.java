package lab5;

public class Patient extends Human {
	private short age;
	private int numberHistory;

	Patient(String name, String surname, String patronymic, String phone, String address, short age,
			int numberHistory) {
		super(name, surname, patronymic, phone, address);
		this.age = age;
		this.numberHistory = numberHistory;
	}

	@Override
	public String toString() {
		return getSurname() + ' ' + getName() + ' ' + getPatronymic() + "\nвозраст" + age + "\nномер истории болезни"
				+ numberHistory + "\nтел. " + getPhone() + "\nадрес " + getAddress();
	}

	public short getAge() {
		return age;
	}

	public int getNumberHistory() {
		return numberHistory;
	}
}
