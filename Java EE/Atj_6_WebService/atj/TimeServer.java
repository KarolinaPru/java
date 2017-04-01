/**
 * TimeServer.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package atj;

public interface TimeServer extends java.rmi.Remote {
	
    public java.lang.String getTimeAsString() throws java.rmi.RemoteException;
    public long getTimeAsElapsed() throws java.rmi.RemoteException;
}
