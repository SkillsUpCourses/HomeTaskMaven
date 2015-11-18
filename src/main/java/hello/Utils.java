package hello;

import com.pb.util.gsv.net.HTTPClient;
import org.w3c.dom.Node;

public class Utils {

    public static final String sid = "***";
    public static final String url = "https://msg.privatbank.ua/MSG";
    //public static final String url = "https://msg.stage.it.loc:/MSG";
    public static final HTTPClient client = new HTTPClient();

    public static Node getNextNode(Node node) {
        return getNode(node.getNextSibling());
    }

    public static Node getChildNode(Node node) {
        return getNode(node.getFirstChild());
    }

    private static Node getNode(Node node) {
        while (node != null) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                return node;
            }
            node = node.getNextSibling();
        }
        return null;
    }

    public static String correctValue(String value) {
        if (value == null) {
            value = "";
        }
        value = value.replaceAll("\\s+", " ");
        value = value.replace("}{", "} {");
        value = value.replace("&", "&amp;");
        value = value.replace("\\\"", "\"");
        value = value.replace("\"", "&quot;");
        value = value.replace("'", "&#39;");
        value = value.replace("<", "&lt;");
        value = value.replace(">", "&gt;");
        value = value.trim();
        return value;
    }
}
