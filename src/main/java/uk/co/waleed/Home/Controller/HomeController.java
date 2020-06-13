package uk.co.waleed.Home.Controller;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HomeController{

    @RequestMapping("/")
    @ResponseBody
    public String handleError() {
        return String.format("<center><html><body><h1>Welcome to Java Web Service</h1><div>"
                        + "<b>Please use one of the end points to use the webservice such as 'permuation' or 'greeting'"
                        + "</b></div></center>");
    }
}
