import org.json.simple.parser.ParseException;

import java.io.IOException;

import static RestApiTest.Delete.DeleteApiTest;
import static RestApiTest.Get.GetApiTest;
import static RestApiTest.Post.*;
import static RestApiTest.Put.PutApiTest;

public class ApiTest {
    public static void main(String[] args) throws IOException, ParseException {

        GetApiTest();
        PostApiTest();
        PostApiTestFile("İlker");
        PostApiTestJson();
        DeleteApiTest();
        PutApiTest();
    }
}
