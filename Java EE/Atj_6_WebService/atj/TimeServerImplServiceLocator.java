/**
 * TimeServerImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package atj;

public class TimeServerImplServiceLocator extends org.apache.axis.client.Service implements atj.TimeServerImplService {

    public TimeServerImplServiceLocator() {
    }


    public TimeServerImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TimeServerImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TimeServerImplPort
    private java.lang.String TimeServerImplPort_address = "http://127.0.0.1:9000/ts";

    public java.lang.String getTimeServerImplPortAddress() {
        return TimeServerImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TimeServerImplPortWSDDServiceName = "TimeServerImplPort";

    public java.lang.String getTimeServerImplPortWSDDServiceName() {
        return TimeServerImplPortWSDDServiceName;
    }

    public void setTimeServerImplPortWSDDServiceName(java.lang.String name) {
        TimeServerImplPortWSDDServiceName = name;
    }

    public atj.TimeServer getTimeServerImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TimeServerImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTimeServerImplPort(endpoint);
    }

    public atj.TimeServer getTimeServerImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            atj.TimeServerImplPortBindingStub _stub = new atj.TimeServerImplPortBindingStub(portAddress, this);
            _stub.setPortName(getTimeServerImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTimeServerImplPortEndpointAddress(java.lang.String address) {
        TimeServerImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (atj.TimeServer.class.isAssignableFrom(serviceEndpointInterface)) {
                atj.TimeServerImplPortBindingStub _stub = new atj.TimeServerImplPortBindingStub(new java.net.URL(TimeServerImplPort_address), this);
                _stub.setPortName(getTimeServerImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("TimeServerImplPort".equals(inputPortName)) {
            return getTimeServerImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://atj/", "TimeServerImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://atj/", "TimeServerImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TimeServerImplPort".equals(portName)) {
            setTimeServerImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
