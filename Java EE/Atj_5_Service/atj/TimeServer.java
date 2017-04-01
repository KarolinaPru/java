package atj;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface TimeServer {
	@WebMethod
	String getTimeAsString();
	@WebMethod
	long getTimeAsElapsed();

}
