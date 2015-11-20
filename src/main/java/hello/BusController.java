package hello;

import static hello.AddNewBusId.insertBusId;
import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusController {

//    private static final String template = "Hello, %s, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/createbus")
    public BusEntity createbus(@RequestParam(value="sid", defaultValue="null") String sid, 
                             @RequestParam(value="busId", defaultValue="null") String busId,
                             @RequestParam(value="deparLogin", defaultValue="null") String deparLogin,
                             @RequestParam(value="respPerson", defaultValue="null") String respPerson,
                             @RequestParam(value="email", defaultValue="null") String email,
                             @RequestParam(value="descr", defaultValue="null") String descr) {
        try {
            com.pb.util.gsv.net.protocol.https.SSLContextFactory.registerDefaultSSLSocketFactory();
        } catch (GeneralSecurityException ex) {
           ex.printStackTrace(); //Logger.getLogger(AddNewBusId.class.getName()).log(Level.SEVERE, null, ex);
        }
        String answer = insertBusId(sid, busId, deparLogin, respPerson, email, descr);
        return new BusEntity(sid, busId, deparLogin, respPerson, email, descr, answer);
        
    }
   
    
    
    
}