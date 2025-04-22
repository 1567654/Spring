package se.yrgo.client;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.yrgo.domain.Call;
import se.yrgo.services.calls.CallHandlingService;
import se.yrgo.services.customers.CustomerManagementService;
import se.yrgo.services.customers.CustomerNotFoundException;

import java.util.ArrayList;

public class SimpleClient {

    public static void main(String[] args) throws CustomerNotFoundException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application.xml");

//        CustomerManagementService service =
//                context.getBean("customerManagementService", CustomerManagementService.class);
        CallHandlingService callHandlingService = (CallHandlingService) context.getBean("callHandlingService");
        callHandlingService.recordCall("OB74", new Call("buying soda"), new ArrayList<>());
        context.close();
    }
}