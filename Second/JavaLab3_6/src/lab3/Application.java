package lab3;

import lab3.sample.AbstractMediaFactory;

/*6. Паттерн Abstract Factory. Написать код приложения, позволяющий 
 * сохранять регистрационные данные пользователя в xml файл. 
 * Состав регистрационных данных у каждого пользователя может быть различен.
 */
public class Application {
	private ComplexProfile complexProfile;
	private SimpleProfile simpleProfile;

	public Application(AbstractProfileFactory factory) {
		complexProfile = factory.createComplexProfile();
		simpleProfile = factory.createSimpleProfile();
		// использование созданных объектов
	}
	public void create(String login1, String password1, String login2, String password2)
	{
		simpleProfile.register(login1, password1);
		complexProfile.register(login2, password2);
	}
}
