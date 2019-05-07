/**
 * WebS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.moggz;

public interface WebS extends javax.xml.rpc.Service {
    public java.lang.String getWebSSoapAddress();

    public com.moggz.WebSSoap getWebSSoap() throws javax.xml.rpc.ServiceException;

    public com.moggz.WebSSoap getWebSSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
