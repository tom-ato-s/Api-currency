/*
 Контроллер для запросов на внешние API
 openexchangerates.org  - получение курса валют
 giphy.com - получение gif
*/

package com.example.Apicurrency.autApi;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient()
public interface AutController{

    /**
     * Курс на сегодня
     *
     * @param app_id
     * @return courseResponse
     */

    @RequestLine("GET /latest.json?app_id={app_id}")
    String getCourseNow(@Param("app_id") String app_id);

    /**
     * Курс на вчера
     *
     * @param date_yesterday, app_id
     * @return
     */
    @RequestLine("GET /historical/{date_yesterday}.json?app_id={app_id}")
    String getCourseYesterday(@Param("date_yesterday") String date_yesterday, @Param("app_id") String app_id);

    /**
     * запрос gif-картинки Rich или Broke
     * @param api_key, tag
     * @return
     */
    @RequestLine("GET ?api_key={api_key}&tag={tag}&rating=g")
    String getGif(@Param("api_key") String api_key, @Param("tag") String tag);

}


