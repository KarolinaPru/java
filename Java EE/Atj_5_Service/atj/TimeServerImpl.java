package atj;

import java.util.Date;

import javax.jws.WebService;

@WebService(endpointInterface="atj.TimeServer")
public class TimeServerImpl implements TimeServer{

	@Override
	public String getTimeAsString() {
		return new Date().toString();
	}

	@Override
	public long getTimeAsElapsed() {
		return new Date().getTime();
	}

}
