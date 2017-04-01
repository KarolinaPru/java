package atj;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class TimeClient {
  public static void main(String args[])
    throws Exception {
    URL url = new URL("http://localhost:9000/ts?wsdl");
    
    //  URI, service name z WSDL
    QName qname=new QName("http://atj/",
			"TimeServerImplService");
    // najpierw tworzy factory, potem interfejs
    Service service = Service.create(url, qname);
    atj.TimeServer eif=
		service.getPort(atj.TimeServer.class);
    System.out.println(eif.getTimeAsString());
    System.out.println(eif.getTimeAsElapsed());
  }
}