package com.example.Apicurrency.autApi;


import feign.Feign;
import java.net.URISyntaxException;

public class AutMain {
    private static String date_yesterday = "2022-06-06";
    private static String someCallbackFunction = "someCallbackFunction";
    private static String app_id = "03a6c20a691540d4afea051b31578752";
    private static String url_curs = "https://openexchangerates.org/api/";
    private static String BUNDLE = "messaging_non_clips";

    static TodayMore todayMore = new TodayMore();
    public static void main(String[] args) throws URISyntaxException {

        String valuta = "RUB";

       //Подключение к API курса валют
        AutController autController = Feign.builder()
                .target(AutController.class, "https://openexchangerates.org/api/");

        //Запрос курса на сегодня
        String nowCourses = autController.getCourseNow("03a6c20a691540d4afea051b31578752");

//        //Запрос курса на вчера
        String yesterdayCourses = autController.getCourseYesterday("2022-06-06", "03a6c20a691540d4afea051b31578752");

        // сравниваем курсы

        boolean more = todayMore.todayMore(nowCourses, yesterdayCourses, valuta);
        String tag;

        if(more == true) {
            //запрос гифки rich
            tag = "rich";
        } else {
            //запрос гифки
            tag = "broke";
        }
        //       Подключение к API gif
        AutController autInterface2 = Feign
                .builder()
                .target(AutController.class, "https://api.giphy.com/v1/gifs/random");
//
        String gifJson = autInterface2.getGifRich("VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P", tag);

        getLinkJson();

 //       System.out.println(autInterface2.getGifRich3("api_key", LIMIT, OFFSET, BUNDLE));














//        CourseClient courseClient = Feign.builder()
//                .target(CourseClient.class, "https://openexchangerates.org/api/");
//
//      //  System.out.println(courseClient.getCourse());
//        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
