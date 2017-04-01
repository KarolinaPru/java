package atj;

import javax.xml.ws.Endpoint;

public class TimeServerPublisher {
    public static void main(String[ ] args) {
      Endpoint.publish("http://127.0.0.1:8888/ts",
			 new atj.TimeServerImpl());
    }
}