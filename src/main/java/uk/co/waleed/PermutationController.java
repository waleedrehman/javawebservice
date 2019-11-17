package uk.co.waleed;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PermutationController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/permutation")
    public Greeting greeting(@RequestParam(value="permuteInt", defaultValue="326") String permuteInt) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, permuteInt));
    }
}
