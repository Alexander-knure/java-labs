package lab3.sample;

public class VideoFactory extends AbstractMediaFactory {
	   public TCPMediaContent createTCPObject() {
	        return new TCPVideoContent();
	   }
	    public UDPMediaContent createUDPObject() {
	        return new UDPVideoContent();
	   }
	}

