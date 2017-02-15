package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class JSONReader {

    public static void main(String[] args) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(new FileReader("D:\\JAVA\\GitHub\\Test02\\otherDemo\\src\\main\\resources\\test.json"));
        System.out.println("cat = "+object.get("cat").getAsString());
        System.out.println("pop = "+object.get("pop").getAsString());
        JsonArray array = object.get("languages").getAsJsonArray();
        for (JsonElement jsonElement : array) {
            System.out.println("-----------------------------");
            JsonObject subJson = (JsonObject) jsonElement;
            System.out.print("id = "+subJson.get("id").getAsInt());
            System.out.print("  ide = "+subJson.get("ide").getAsString());
            System.out.println("  name = "+subJson.get("name").getAsString());
            System.out.println("-----------------------------");
        }
    }
}
