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
        return String.format("<center><h1>Welcome to Java Web Service</h1>"
                        + "<div><b>Please use one of the end points to use the webservice"
                        + "<br />'permutation' requires parameter permuteInt: "
                        + "<a href='permutation?permuteInt=123'>/permutation?permuteInt=123</a>"
                        + "<br />'greeting' requires parameter name: "
                        + "<a href='greeting?name=Waleed'>/greeting?name=Waleed</a>"
                        + "</b></div></center>");
    }
}
