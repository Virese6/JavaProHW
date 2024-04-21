package client;

import app.controller.EmployeeController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Client {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext("app");
        EmployeeController controller = context.getBean(EmployeeController.class);
        System.out.println(controller.getById(1L));
    }
}
