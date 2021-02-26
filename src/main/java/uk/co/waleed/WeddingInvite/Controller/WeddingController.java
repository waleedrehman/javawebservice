package uk.co.waleed.WeddingInvite.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

@RestController
@Controller
@CrossOrigin(origins = "*")
public class WeddingController{

    //https://docs.spring.io/spring/docs/5.1.6.RELEASE/spring-framework-reference/integration.html#mail
    @Autowired
    private JavaMailSender javaMailSender;

    @CrossOrigin(origins = "*")
    @RequestMapping("/inviteAcceptance")
    @ResponseBody
    public String email(@RequestParam(value="name") String name,
                        @RequestParam(value="email") String email,
                        @RequestParam(value="numguest") String numguest,
                        @RequestParam(value="allevents") String allevents,
                        @RequestParam(value="attending") String attending) throws MessagingException {
        if (name != "" && email != "" ) {
            sendEmail( name, email, numguest, allevents, attending);
        }
        else {
            return "Validation Failed";
        }
        return String.format("success");
    }

    void sendEmail(String name, String email, String numguest, String allevents, String attending) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = String.format("<p>Email: %s</p>",email) +
                String.format("<p>Subject: %s</p>","Wedding Invite Acceptance") +
                String.format("<p>Name: %s</p>",name) +
                String.format("<p>Number of Guests: %s</p>",numguest)+
                String.format("<p>Events Attending: %s</p>",allevents)+
                String.format("<p>Attending?: %s</p>",attending);
        helper.setText(htmlMsg, true); // Use this or above line.
        helper.setTo("hello@waleedrehman.co.uk");
        helper.setSubject("Wedding Invite Acceptance");
        helper.setFrom("admin@waleedrehman.co.uk");
        helper.setReplyTo(email);
        javaMailSender.send(mimeMessage);
    }
}
