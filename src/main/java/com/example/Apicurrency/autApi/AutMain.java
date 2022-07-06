/*
Клас для работы с внешними API
*/

package com.example.Apicurrency.autApi;

import feign.Feign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class AutMain {


    private static String someCallbackFunction = "someCallbackFunction";
    private static String app_id = "03a6c20a691540d4afea051b31578752";
    private static String url_curs = "https://openexchangerates.org/api/";
    private static String BUNDLE = "messaging_non_clips";

    static TodayMore todayMore = new TodayMore();
    static LinkJson linkJson = new LinkJson();


    private static String getYesterday(){
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return
                yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //Класс принимает валюту
    // Класс возвращает ссыку на gif
    public static String autMain(String valuta) throws URISyntaxException, IOException {





        FileInputStream fis;
        Properties property = new Properties();
        fis = new FileInputStream("src/main/resources/config.properties");
        property.load(fis);




        //Подключение к API курса валют
        AutController autController = Feign.builder()
                .target(AutController.class, "https://openexchangerates.org/api/");

        //Запрос курса на сегодня
        String nowCourses = autController.getCourseNow("03a6c20a691540d4afea051b31578752");

        // получаем вчерашнюю дату
        String date_yesterday = getYesterday();


        String yesterdayCourses = autController.getCourseYesterday(date_yesterday, "03a6c20a691540d4afea051b31578752");

        // Сравниваем курсы
        boolean more = todayMore.todayMore(nowCourses, yesterdayCourses, valuta);
        String tag;
        if (more == true) {
            //запрос гифки rich
            tag = "rich";
        } else {
            //запрос гифки broke
            tag = "broke";
        }

        // Подключение к API gif
        AutController autInterface2 = Feign
                .builder()
                .target(AutController.class, "https://api.giphy.com/v1/gifs/random");

        // Получение ссылки на gif
        String gifJson = autInterface2.getGif("VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P", tag);

        return linkJson.getLinkJson(gifJson);
    }
}