/*
 Контроллер для запросов на внешние API
 openexchangerates.org  - получение курса валют
 giphy.com - получение gif
*/

package com.example.Apicurrency.autApi;

import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient()
public interface AutController{
    String app_id = "03a6c20a691540d4afea051b31578752";

    /**
     * Курс на сегодня
     *
 //    * @param app_id
     * @return courseResponse
     */

    @RequestLine("GET /latest.json?app_id={app_id}")
    String getCourseNow(@Param("app_id") String app_id);

    // https://openexchangerates.org/api/latest.json?app_id=03a6c20a691540d4afea051b31578752


    /**
     * Курс на вчера
     *
     * @param date_yesterday, app_id
     * @return
     */
    @RequestLine("GET /historical/{date_yesterday}.json?app_id={app_id}")
    String getCourseYesterday(@Param("date_yesterday") String date_yesterday, @Param("app_id") String app_id);

// https://openexchangerates.org/api/historical/2022-06-06.json?app_id=03a6c20a691540d4afea051b31578752
//    /**
//     * Повышение курса 1 param
//     * запрос gif-картинки Rich
//     *
//     */
//    @RequestLine("GET ?api_key={api_key}")
//      @Headers("Accept: text/html")
//    String getGifRich(@Param("api_key") String api_key);
//



    /**
     * Повышение курса 2 param bundle
     *      * запрос gif-картинки Rich или Broke
     *
     */
    @RequestLine("GET ?api_key={api_key}&tag={tag}&rating=g")
 //   @Headers("Accept: text/html")
    String getGif(@Param("api_key") String api_key, @Param("tag") String tag);


    // https://giphy.com/search/rich?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&limit=1&offset=22
    // https://api.giphy.com/v1/gifs
    //   /rendom
    //   ?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=rich
//    https://api.giphy.com/v1/gifs/rendom?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=rich
}
// запрос 1 gif в нем 1
// "URL": "https://giphy.com/gifs/make-it-rain-get-paid-LdOyjZ7io5Msw"
///// https://api.giphy.com/v1/gifs/search?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&q=rich&limit=1&offset=0&rating=g&lang=en

// rendom
// пример ссылки на картинку "URL":" https://giphy.com/gifs/APMEX-gold-silver-apmex-L1QMTl9ggmYGoCu7oj "


// https://api.giphy.com/v1/gifs/random?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=rich&rating=g





//broke

//    https://api.giphy.com/v1/gifs/random?api_key=VKcwC5rNwIqSznKEkm9FdoNHh0LrWq6P&tag=broke&rating=g


