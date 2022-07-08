/*
Клас для работы с внешними API
*/

package com.example.Apicurrency.autApi;

import feign.Feign;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AutMain {
    static TodayMore todayMore = new TodayMore();
    static LinkJson linkJson = new LinkJson();

//    @Value("${course.url}")
//    private static String utl;

    private static String getYesterday(){
        LocalDate yesterday = LocalDate.now().minusDays(1);
        return
                yesterday.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    //формирование html - стриницы с gif
    private static String getHtml(String link) {
        String pre = "<HTML>\n" +
                "     <HEAD>\n" +
                "    <meta charset=\"utf-8\"> \n" +
                "     \t\t<TITLE> Действие - Вставка анимированного GIF-файла в HTML</TITLE> \n" +
                "     </HEAD>\n" +
                "      <BODY>\n" +
                "          <img src=\"";
        String afte = "\">\n" +
                "                \n" +
                "      </BODY>\n" +
                "</HTML>\n";
        return pre + link + afte;
    }

    /*
    Класс принимает валюту
    Класс возвращает ссыку на gif
     */
    public static String autMain(String valuta) {

        //Подключение к API курса валют
        AutController autController = Feign.builder()
                .target(AutController.class, "https://openexchangerates.org/api/");

        //Запрос курса на сегодня
        String nowCourses = autController.getCourseNow("03a6c20a691540d4afea051b31578752");

       // получаем вчерашнюю дату
        String date_yesterday = getYesterday();
        //Запрос курса на вчера
        String yesterdayCourses = autController.getCourseYesterday(date_yesterday, "03a6c20a691540d4afea051b31578752");
        // Сравниваем курсы
        boolean more = todayMore.todayMore(nowCourses, yesterdayCourses, valuta);
        String tag;
        if (more) {
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

        // возвращение html страницы с gif
        return getHtml(linkJson.getLinkJson(gifJson));
    }
}