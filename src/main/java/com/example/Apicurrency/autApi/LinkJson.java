/*
Класс парсит json с gif-ссылкой
и возвращает ссылку на gif
 */

package com.example.Apicurrency.autApi;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkJson {
    public String getLinkJson(String gifJson) {
        // парсинг json
        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map< String, Object > jsonMap = springParser.parseMap(gifJson);
        LinkedHashMap<String,Object> datasMap = (LinkedHashMap<String, Object>) jsonMap.get("data");
        LinkedHashMap<String,Object> imagesMap  = (LinkedHashMap<String,Object>)datasMap.get("images");
        LinkedHashMap<String,String> fixed_width_stillMap = (LinkedHashMap<String,String>)imagesMap.get("fixed_width_still");

        return fixed_width_stillMap.get("url");
    }

}
