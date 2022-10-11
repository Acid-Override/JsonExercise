package exercise.utils;

import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;

public class JsonReader
{
    public JSONObject getJson(String path)
    {
        try (InputStream inputStream = this.getClass().getResourceAsStream(path))
        {
            if (inputStream != null)
            {

                return new JSONObject(new String(inputStream.readAllBytes()));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}
