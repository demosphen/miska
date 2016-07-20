package lv.javaguru.java2.servlet;

import lv.javaguru.java2.servlet.MVCController;
import lv.javaguru.java2.servlet.MVCModel;

import javax.servlet.http.HttpServletRequest;

public class HelloWorldController implements MVCController {

    public MVCModel execute(HttpServletRequest request) {
        return new MVCModel("Hello from MVC", "/helloWorld.jsp");
    }

}
