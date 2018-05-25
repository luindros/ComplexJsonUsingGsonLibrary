package com.luindros.gsoncomplejo;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Deserializer  implements JsonDeserializer<Weather> {

    @Override
    public Weather deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            /*
            private String cod;
            private String name;
            private String country;
            private String description;
            */


            JsonArray listJson =json.getAsJsonObject().get("list").getAsJsonArray();
            JsonObject listObjectJson=listJson.get(0).getAsJsonObject();
            JsonObject sysObject=listObjectJson.get("sys").getAsJsonObject();
            JsonArray weatherListJson=listObjectJson.get("weather").getAsJsonArray();
            JsonObject weatherObjectJson=weatherListJson.get(0).getAsJsonObject();


            String cod=json.getAsJsonObject().get("cod").getAsString();
            String name=listObjectJson.get("name").getAsString();
            String country=sysObject.get("country").getAsString();
            String description=weatherObjectJson.get("description").getAsString();

            Weather weather=new Weather(cod,name,country,description);
            return weather;

    }
}