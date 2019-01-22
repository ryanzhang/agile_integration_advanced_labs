package com.redhat.usecase.service;

import com.sun.mdm.index.webservice.ExecuteMatchUpdate;

import javax.jws.WebService;


@WebService
public interface NextgateWS {
  public ExecuteMatchUpdate execute(ExecuteMatchUpdate person);
}
