package hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Заливка сообщений из файла
 *
 * @author Dima
 */
public class NewPour_advanced {

//    public static void main(String[] args)  {
//        try {
//            com.pb.util.gsv.net.protocol.https.SSLContextFactory.registerDefaultSSLSocketFactory();
//        } catch (GeneralSecurityException ex) {
//            ex.printStackTrace();
//        }
//        run();
//    }

    private static void run()   {
            String line;
            String msgCode = "";
            int iterate = 0;
            StringBuilder query = new StringBuilder();
            StringBuilder sbSub = new StringBuilder();
            Map<String,String> msgMap = new HashMap<>();
        try {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader("C:\\Users\\ЕКБ\\Desktop\\KVITKA.txt"));
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            while ((line = br.readLine()) != null) {
                line = new String(line.getBytes(), "UTF-8");
                line = line.trim();
                if (line.length() == 0) {
                    continue;
                }
                
                String[] values = line.split("\\(\\]");
                
                //Проверка выполнения 
                if (!values[2].equals(msgCode)){
                query.setLength(0);
                query.append("<?xml version='1.0' encoding='UTF-8'?>");
                query.append("<doc>");
                query.append("<r t='MSG_ADD' sid='").append(Utils.sid).append("'>");
                query.append("<s ");
                query.append("         Type='").append(Utils.correctValue(values[0])).append("' ");
                query.append("TemplateMsgId='").append(Utils.correctValue(values[1])).append("' ");
                query.append("      MsgCode='").append(Utils.correctValue(values[2].trim().replace(" ", "_"))).append("' ");
                msgCode = Utils.correctValue(values[2].trim().replace(" ", "_"));
                
                query.append("        Descr='").append(Utils.correctValue(values[3])).append("' ");
                query.append("        BusId='").append(Utils.correctValue(values[4])).append("'>");
                
                query.append("<LocalMsg ");
                query.append("   Level='").append(Utils.correctValue(values[5])).append("' ");
                query.append("    Lang='").append(Utils.correctValue(values[6])).append("' ");
                query.append("    Text='").append(Utils.correctValue(values[7])).append("' ");
                query.append("   Title='").append(Utils.correctValue(values[8])).append("'/>");
//            query.append("FullText='").append(Utils.correctValue(values[7])).append("'/>");
                msgMap.put(msgCode, query.toString());
                
                
                }else {
                    query.append("<LocalMsg ");
                    query.append("   Level='").append(Utils.correctValue(values[5])).append("' ");
                    query.append("    Lang='").append(Utils.correctValue(values[6])).append("' ");
                    query.append("    Text='").append(Utils.correctValue(values[7])).append("' ");
                    query.append("   Title='").append(Utils.correctValue(values[8])).append("'/>");
                
                    for(Map.Entry<String, String> entry : msgMap.entrySet()){


                        if(entry.getKey().equals(msgCode)){

                                sbSub.append(entry.getValue()).append(query);                
                                entry.setValue(sbSub.toString());                            
                                sbSub.setLength(0);

                        }
                        
                        
                        
                        
                        

                    }
                
                }

            
                    query.setLength(0);

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //Выхов методов для регистрации шаблонов сообщений
        writeMsg(parseMsgToMap(msgMap));
             
        
        
    }
    
    
      //Добавляем закрывающие теги запросов
        public static Map<String, String> parseMsgToMap (Map<String,String> map){
    
            StringBuilder sb = new StringBuilder();
                for(Map.Entry<String, String> entry : map.entrySet()){              
                sb.append(entry.getValue()).append("</s>").append("</r>").append("</doc>");                
                entry.setValue(sb.toString());                           
                sb.setLength(0);
                
                }
        return map;

    
        }
        
      //Отправка запросов на регистрацию шаблонов сообщений
        public static void writeMsg(Map<String, String> map){
        
            byte[] buff = null;
            String answer = null;
            for(Map.Entry<String, String> entry : map.entrySet()){ 
                System.out.println(entry.getValue().toString());
//                try {
//                buff = Utils.client.post(Utils.url, entry.getValue().toString().getBytes("UTF-8"));
//                answer = new String(buff, "UTF-8");
//
//                } catch (UnsupportedEncodingException ex) {
//                   ex.printStackTrace();
//                } catch (Exception ex) {
//                   ex.printStackTrace();
//                }
//
//
//                if (!answer.contains("<Msg ")) {
//                    System.out.println(entry.getValue().toString());
//                }
            
            }
            


        
        }
}
