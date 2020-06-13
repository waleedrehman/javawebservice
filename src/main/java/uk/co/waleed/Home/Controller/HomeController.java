package uk.co.waleed.Home.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController{

    @RequestMapping("/")
    @ResponseBody
    public String handleError() {
        return String.format("<center><h1>Welcome to Java Web Service</h1>"
                        + "<b>Please use one of the end points to use the webservice"
                        + "<br />'permutation' requires parameter permuteInt: "
                        + "<a href='permutation?permuteInt=123'>/permutation?permuteInt=123</a>"
                        + "<br />'greeting' requires parameter name: "
                        + "<a href='greeting?name=Waleed'>/greeting?name=Waleed</a>"
                        + "</b></center>");
    }
}
