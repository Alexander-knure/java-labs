package lab3.sample;

public class AudioFactory extends AbstractMediaFactory {
	   public TCPMediaContent createTCPObject() {
	       return new TCPAudioContent();
	  }
	   public UDPMediaContent createUDPObject() {
	       return new UDPAudioContent();
	   }
	}

