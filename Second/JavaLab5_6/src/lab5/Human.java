package lab5;

public abstract class Human {
	private String name;
	private String surname;
	private String patronymic;
	private String phone;
	private String address;
	
	Human(String name, String surname, String patronymic, String phone, String address)
	{
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.phone = phone;
		this.address = address;
	}
	
	public String getName() { return name;};
	public String getSurname() {return surname;};
	public String getPatronymic() {return patronymic;};
	public String getPhone() {return phone;};
	public String getAddress() {return address;};
}
