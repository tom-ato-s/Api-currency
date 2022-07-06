/*
Класс парсит json с gif-ссылкой
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
        LinkedHashMap<String,String> ratesMap = (LinkedHashMap<String, String>) jsonMap.get("data");
        return ratesMap.get("url");
    }

}
