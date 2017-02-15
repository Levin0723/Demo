package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JSONWirter {

    public static void main(String[] args) {
        JsonObject object = new JsonObject();
        object.addProperty("cat","it");

        JsonArray array = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id",1);
        lan1.addProperty("ide","Eclipse");
        lan1.addProperty("name","java");
        array.add(lan1);

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id",2);
        lan2.addProperty("ide","XCode");
        lan2.addProperty("name","Swift");
        array.add(lan2);

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id",3);
        lan3.addProperty("ide","Visual");
        lan3.addProperty("name","C#");
        array.add(lan3);

        object.add("languages",array);

        object.addProperty("pop",true);

        System.out.println(object.toString());
    }
}
