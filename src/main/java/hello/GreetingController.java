package hello;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

//    private static final String template = "Hello, %s, %s!";
//    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="sid", defaultValue="null") String sid, 
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
        GreetingController gc = new GreetingController();
        gc.createBusID(sid, busId, deparLogin, respPerson, email, descr);
        return new Greeting(sid, busId, deparLogin, respPerson, email, descr);
    }
   
      @RequestMapping("/checkbusid")  
  public String checkBusID(@RequestParam(value="busId") String busId){
  
    return "BusId"+busId+"not found";
  }  
    
    
  @RequestMapping("/createbusid")  
  public String createBusID(String sid, String busId, String deparLogin,String respPerson, String email, String descr){
          AddNewBusId add = new AddNewBusId();
          return add.insertBusId(sid, busId, deparLogin,respPerson, email, descr);

  }  
    
}