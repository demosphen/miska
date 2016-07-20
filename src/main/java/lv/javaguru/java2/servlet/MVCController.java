package lv.javaguru.java2.servlet;

import javax.servlet.http.HttpServletRequest;

public interface MVCController {

    MVCModel execute(HttpServletRequest request);

}
