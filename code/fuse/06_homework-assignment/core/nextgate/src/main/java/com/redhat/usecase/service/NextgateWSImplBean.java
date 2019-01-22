package com.redhat.usecase.service;


import com.redhat.usecase.service.NextgateWS;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.sun.mdm.index.webservice.ExecuteMatchUpdate;


@WebService(endpointInterface = "com.redhat.usecase.service.CustomerWS")
public class NextgateWSImplBean implements NextgateWS {

  public NextgateWSImplBean() {

  }

  @WebResult(name = "ExecuteMatchUpdate")
  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  public ExecuteMatchUpdate execute(ExecuteMatchUpdate person) {
      
      return person;
  }

}
