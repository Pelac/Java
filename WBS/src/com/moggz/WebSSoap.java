/**
 * WebSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.moggz;

public interface WebSSoap extends java.rmi.Remote {
    public java.lang.String open(java.lang.String fileName) throws java.rmi.RemoteException;
    public java.lang.String[][] getMovies() throws java.rmi.RemoteException;
    public java.lang.String[][] getEmployees() throws java.rmi.RemoteException;
    public java.lang.String[][] getEmpAbsence() throws java.rmi.RemoteException;
    public java.lang.String[][] getEmpRelative() throws java.rmi.RemoteException;
    public java.lang.String[][] getQualification() throws java.rmi.RemoteException;
    public java.lang.String[][] getPortal() throws java.rmi.RemoteException;
    public java.lang.String[][] getStats() throws java.rmi.RemoteException;
    public java.lang.String[][] getIndexes() throws java.rmi.RemoteException;
    public java.lang.String[][] getSick() throws java.rmi.RemoteException;
    public java.lang.String[][] getContract() throws java.rmi.RemoteException;
    public java.lang.String[][] getMostSick() throws java.rmi.RemoteException;
    public java.lang.String[][] getKeys() throws java.rmi.RemoteException;
    public java.lang.String[][] getConstraints() throws java.rmi.RemoteException;
    public java.lang.String[][] getAllTables1() throws java.rmi.RemoteException;
    public java.lang.String[][] getAllTables2() throws java.rmi.RemoteException;
    public java.lang.String[][] getAllEmpTables1() throws java.rmi.RemoteException;
    public java.lang.String[][] getAllEmpTables2() throws java.rmi.RemoteException;
    public void removeEmpRelative(java.lang.String empNbr, int lnNbr) throws java.rmi.RemoteException;
    public void createEmpRelative(java.lang.String empNbr, int lnNbr, java.lang.String relCode, java.lang.String fName, java.lang.String lName) throws java.rmi.RemoteException;
    public void updateEmpRelative(java.lang.String empNbr, int lnNbr, java.lang.String relCode, java.lang.String fName, java.lang.String lName) throws java.rmi.RemoteException;
    public java.lang.String[][] getEmpRel() throws java.rmi.RemoteException;
}
