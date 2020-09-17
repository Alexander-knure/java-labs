package lab3.sample;

public abstract class AbstractMediaFactory {
	public abstract TCPMediaContent createTCPObject();

	public abstract UDPMediaContent createUDPObject();

}
