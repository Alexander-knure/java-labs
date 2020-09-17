package lab3;

public class Master extends SimpleProfile {	
	
	@Override
	public void register(String login, String password) { // more code
		if (!login.isEmpty() && !password.isEmpty() && password.length() >= 8) {
			this.login = login;
			this.password = encode(password, "master");
			this.status = "master";
			// TODO save in XML format
		} else {
			System.out.println("master: login or password is wrong!");
		}
		System.out.println("master created");
	}
	
	private String encode(String pText, String pKey) {
		byte[] txt = pText.getBytes();
		byte[] key = pKey.getBytes();
		byte[] res = new byte[pText.length()];

		for (int i = 0; i < txt.length; i++) {
			res[i] = (byte) (txt[i] ^ key[i % key.length]);
		}
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
