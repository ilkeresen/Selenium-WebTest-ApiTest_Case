package JsonOperations;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FileJson {
    public static Object GetFileJson(String UserName) throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src/test/resources/users.json");
        Object obj = jsonParser.parse(reader);
        JSONArray usersList = (JSONArray) obj;
        for(int i=0;i<usersList.size();i++) {
            JSONObject users = (JSONObject) usersList.get(i);
            JSONObject user = (JSONObject) users.put("users","name");
            if (user.containsValue(UserName)){
                return user;
                //System.out.println(user);
            }
        }
        return null;

    }
}
