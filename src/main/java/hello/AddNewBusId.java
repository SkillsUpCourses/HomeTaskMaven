/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.lang.StringBuilder;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ЕКБ
 */
public class AddNewBusId {
    
//    public static void main (String ... args) {
//        try {
//            com.pb.util.gsv.net.protocol.https.SSLContextFactory.registerDefaultSSLSocketFactory();
//        } catch (GeneralSecurityException ex) {
//           ex.printStackTrace(); //Logger.getLogger(AddNewBusId.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        insertBusId("151015pb1rwwxud14qh", "TEST", "IT170P000000","dn091086saa", "123567878@privatbank.ua", "тесты");
//     }

    static String insertBusId(String sid, String busId, String deparLogin, String respPerson, String email, String descr){
    
    
    StringBuilder builder = new StringBuilder();
    
    builder.setLength(0);
    builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
    builder.append("<doc>");
    builder.append("<r sid=\"").append(sid).append("\" t=\"BUS_PROC_ADD_AND_EDIT\">");
    builder.append("<s BusId=\"").append(busId).append("\" DeparLogin=\"").append(deparLogin);
    builder.append("\" ResponsiblePerson=\"").append(respPerson).append("\" Email=\"").append(email);
    builder.append("\" Descr=\"").append(descr).append("\"/>");
    builder.append("</r>");
    builder.append("</doc>");
                  
    byte[] buff = null;
        try {
            buff = Utils.client.post(Utils.url, builder.toString().getBytes("UTF-8"));
        } catch (Exception ex) {
            ex.printStackTrace();//Logger.getLogger(AddNewBusId.class.getName()).log(Level.SEVERE, null, ex);
        }
    String answer = null;
        try {
            answer = new String(buff, "UTF-8");
//            System.out.println(answer.toString()); 
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace(); // Logger.getLogger(AddNewBusId.class.getName()).log(Level.SEVERE, null, ex);
        }
   

    if (answer.contains("<BUS_PROC_ADD_AND_EDIT/>")) {
        System.out.println("BusId "+busId+" added");
    return "BusId "+busId+" added";
        
    }  else {
            String [] line =  answer.split("\" ");
            String err = null;
            for(String item : line){
                if(item.contains("errtext=")){
                    err = item;
                    break;
                }
    
            }
            
            System.out.println(err);
        return err;
    }
        
    }
    
}
