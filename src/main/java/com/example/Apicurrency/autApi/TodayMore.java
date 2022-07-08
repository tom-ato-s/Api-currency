/*
Класс парсит json-ны, с курсами валют и сравнивает их
возвращает boolean больше курс сегодня/меньше курс курс сегодня true/false
 */

package com.example.Apicurrency.autApi;

import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import java.util.LinkedHashMap;
import java.util.Map;

public class TodayMore {

    //сравнивает курсы валют на присланную валюту сегодня и вчера с полученых json
    public boolean todayMore(String nowCourses, String yesterdayCourses, String valuta) {

        //парсим json курс валют на сегодня
      double nowCourse = parsingJson(nowCourses, valuta);
       //парсим json курс валют на вчера
      double yesterdayCourse = parsingJson(yesterdayCourses, valuta);
       //сравниваем курсы
      return nowCourse > yesterdayCourse;
    }
    // парсинг json
    private double parsingJson(String courses, String valuta) {

        JsonParser springParser = JsonParserFactory.getJsonParser();
        Map< String, Object > jsonMap = springParser.parseMap(courses);
        LinkedHashMap<String,Double> ratesMap = (LinkedHashMap<String, Double>) jsonMap.get("rates");
        return ratesMap.get(valuta);
    }
}