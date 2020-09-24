import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParseUrl {
    public static void main(String[] args) {
        ParseUrl parseUrl = new ParseUrl();
        HashMap<String, String> res = parseUrl.parse("https://target.com/index.html?pass=12345&port=8080&cookie=&host=localhost");
        showParameters(res);
        res = parseUrl.parse("https://target.com/index.html?port=8080&cookie=&host=localhost");
        showParameters(res);
    }

    private static void showParameters(HashMap<String, String> res) {
        for (Map.Entry<String, String> entry : res.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        if (res.containsKey("pass")) {
            System.out.println("password : " + res.get("pass"));
        }
    }

    private HashMap<String, String> parse(String url) {
        String[] urlParts = url.split("\\?");
        if (urlParts.length > 1) {
            return parseParameters(urlParts[1]);
        }
        return new HashMap<>();
    }

    private HashMap<String, String> parseParameters(String urlPart) {
        HashMap<String, String> result = new LinkedHashMap<>();
        String[] parameters = urlPart.split("&");
        for (int i = 0; i < parameters.length; i++) {
//            System.out.println(parameters[i]);
            String[] param = parameters[i].split("=");
            result.put(param[0], param.length > 1 ? param[1] : "not found");
        }
        return result;
    }
}
