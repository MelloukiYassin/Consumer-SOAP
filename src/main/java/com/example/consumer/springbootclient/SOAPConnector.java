package com.example.consumer.springbootclient;

import com.example.consumer.schemas.person.GetByIdResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import javax.xml.bind.JAXBElement;

public class SOAPConnector extends WebServiceGatewaySupport {

    public GetByIdResponse callWebService(String url, Object request){
        JAXBElement res = (JAXBElement) getWebServiceTemplate().marshalSendAndReceive(url, request);
        return (GetByIdResponse) res.getValue();
    }

}
