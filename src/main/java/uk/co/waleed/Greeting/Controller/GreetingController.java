package uk.co.waleed.Greeting.Controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uk.co.waleed.Greeting.Model.GreetingDTO;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin(origins = "*")
    @RequestMapping("/greeting")
    public GreetingDTO greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new GreetingDTO(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
