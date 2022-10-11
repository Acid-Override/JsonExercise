package exercise.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Random;


public class JsonExpander
{
    static String[][] items = new String[][]{
            {"cake",""},
            {"pretzels",""},
            {"ice cream","must remain frozen"},
            {"bananas",""},
            {"table","assembly required"},
            {"flashlight","batteries not included"},
            {"foot cream","deodorant extra"},
            {"bed freshener","bed bug spray extra"},
            {"laundry detergent",""},
            {"comb",""}
    };

    public static JSONObject expandInventory(JSONObject data){
        String INVENTORY = "inventory";

        if( data.has(INVENTORY))
        {
            data.remove(INVENTORY);
            data.put(INVENTORY, new JSONArray());

            int min = 1;
            int max = 50;
            int numberOfItems = new Random().nextInt(max - min + 1) + min;
            for(int x = min; x < numberOfItems; x++){
                String[] item = items[new Random().nextInt(items.length)];
                JSONObject itemObject = new JSONObject();
                itemObject.put("itemType",item[0]);
                if(!item[1].isEmpty()){
                    itemObject.put("notes",item[1]);
                }
                itemObject.put("inStock",new Random().nextInt(max - min + 1) + min);
                data.getJSONArray(INVENTORY).put(itemObject);
            }
        }

        return data;
    }
}
