package lab3.sample;

/*6. Паттерн Abstract Factory. Написать код приложения, позволяющий 
 * сохранять регистрационные данные пользователя в xml файл. 
 * Состав регистрационных данных у каждого пользователя может быть различен.
 */
public class Client {
	private UDPMediaContent contentUDP;
	private TCPMediaContent contentTCP;

	public void makeMediaFactoryWork(AbstractMediaFactory factory) {
		contentUDP = factory.createUDPObject();
		contentTCP = factory.createTCPObject();
		// использование созданных объектов
	}

}
