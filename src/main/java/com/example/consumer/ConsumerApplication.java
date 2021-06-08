package com.example.consumer;


import com.example.consumer.schemas.person.GetById;
import com.example.consumer.schemas.person.GetByIdResponse;
import com.example.consumer.springbootclient.SOAPConnector;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.FileWriter;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    CommandLineRunner lookup(SOAPConnector soapConnector) {
        return args -> {

            GetById request = new GetById();
            GetByIdResponse response = (GetByIdResponse) soapConnector.callWebService("http://localhost:8090/PersonWebServiceSoap/getById", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Id : " + response.getReturn().getId());
            System.out.println("Name : " + response.getReturn().getName());
        };
    }

}
