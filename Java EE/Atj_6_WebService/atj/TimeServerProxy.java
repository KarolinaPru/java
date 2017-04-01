package atj;

public class TimeServerProxy implements atj.TimeServer {
  private String _endpoint = null;
  private atj.TimeServer timeServer = null;
  
  public TimeServerProxy() {
    _initTimeServerProxy();
  }
  
  public TimeServerProxy(String endpoint) {
    _endpoint = endpoint;
    _initTimeServerProxy();
  }
  
  private void _initTimeServerProxy() {
    try {
      timeServer = (new atj.TimeServerImplServiceLocator()).getTimeServerImplPort();
      if (timeServer != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)timeServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)timeServer)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (timeServer != null)
      ((javax.xml.rpc.Stub)timeServer)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public atj.TimeServer getTimeServer() {
    if (timeServer == null)
      _initTimeServerProxy();
    return timeServer;
  }
  
  public java.lang.String getTimeAsString() throws java.rmi.RemoteException{
    if (timeServer == null)
      _initTimeServerProxy();
    return timeServer.getTimeAsString();
  }
  
  public long getTimeAsElapsed() throws java.rmi.RemoteException{
    if (timeServer == null)
      _initTimeServerProxy();
    return timeServer.getTimeAsElapsed();
  }
  
  
}