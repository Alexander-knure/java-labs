package lab3;

import javax.xml.bind.*;
import java.io.*;

public class Visitor extends SimpleProfile {

	@Override
	public void register(String login, String password) { // more code
		if (!login.isEmpty() && !password.isEmpty() && password.length() >= 8) {
			this.login = login;
			this.password = password;
			this.status = "visitor";
			System.out.println("visitor created");
			// TODO save in XML format
		} else {
			System.out.println("visitor: login or password is wrong!");
		}
	}
	
	private void save()
	{
		try {
			JAXBContext jc = JAXBContext.newInstance(Visitor.class);
			Marshaller ms = jc.createMarshaller();
			ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			ms.marshal(new Visitor(), System.in);
			ms.marshal(new Visitor(), new File("profiles\\Visitor.xml"));
		}
		catch(Exception e){
			System.out.println("visitor: " + e.getMessage());
		}
	}
}
