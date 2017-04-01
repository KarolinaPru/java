package atj;

import java.rmi.RemoteException;

public class Client {

	public static void main(String[] args) throws RemoteException {
		TimeServerProxy proxy  = new TimeServerProxy();
		System.out.println(proxy.getTimeAsString());
		System.out.println(proxy.getTimeAsElapsed());

	}

}
