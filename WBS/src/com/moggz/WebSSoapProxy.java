package com.moggz;

public class WebSSoapProxy implements com.moggz.WebSSoap {
  private String _endpoint = null;
  private com.moggz.WebSSoap webSSoap = null;
  
  public WebSSoapProxy() {
    _initWebSSoapProxy();
  }
  
  public WebSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebSSoapProxy();
  }
  
  private void _initWebSSoapProxy() {
    try {
      webSSoap = (new com.moggz.WebSLocator()).getWebSSoap();
      if (webSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webSSoap != null)
      ((javax.xml.rpc.Stub)webSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.moggz.WebSSoap getWebSSoap() {
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap;
  }
  
  public java.lang.String open(java.lang.String fileName) throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.open(fileName);
  }
  
  public java.lang.String[][] getMovies() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getMovies();
  }
  
  public java.lang.String[][] getEmployees() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getEmployees();
  }
  
  public java.lang.String[][] getEmpAbsence() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getEmpAbsence();
  }
  
  public java.lang.String[][] getEmpRelative() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getEmpRelative();
  }
  
  public java.lang.String[][] getQualification() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getQualification();
  }
  
  public java.lang.String[][] getPortal() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getPortal();
  }
  
  public java.lang.String[][] getStats() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getStats();
  }
  
  public java.lang.String[][] getIndexes() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getIndexes();
  }
  
  public java.lang.String[][] getSick() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getSick();
  }
  
  public java.lang.String[][] getContract() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getContract();
  }
  
  public java.lang.String[][] getMostSick() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getMostSick();
  }
  
  public java.lang.String[][] getKeys() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getKeys();
  }
  
  public java.lang.String[][] getConstraints() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getConstraints();
  }
  
  public java.lang.String[][] getAllTables1() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getAllTables1();
  }
  
  public java.lang.String[][] getAllTables2() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getAllTables2();
  }
  
  public java.lang.String[][] getAllEmpTables1() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getAllEmpTables1();
  }
  
  public java.lang.String[][] getAllEmpTables2() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getAllEmpTables2();
  }
  
  public void removeEmpRelative(java.lang.String empNbr, int lnNbr) throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    webSSoap.removeEmpRelative(empNbr, lnNbr);
  }
  
  public void createEmpRelative(java.lang.String empNbr, int lnNbr, java.lang.String relCode, java.lang.String fName, java.lang.String lName) throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    webSSoap.createEmpRelative(empNbr, lnNbr, relCode, fName, lName);
  }
  
  public void updateEmpRelative(java.lang.String empNbr, int lnNbr, java.lang.String relCode, java.lang.String fName, java.lang.String lName) throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    webSSoap.updateEmpRelative(empNbr, lnNbr, relCode, fName, lName);
  }
  
  public java.lang.String[][] getEmpRel() throws java.rmi.RemoteException{
    if (webSSoap == null)
      _initWebSSoapProxy();
    return webSSoap.getEmpRel();
  }
  
  
}