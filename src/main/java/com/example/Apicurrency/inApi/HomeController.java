/*
Controller для входящих запросов на сервер
получает валюту
возвращает html c gif
 */

package com.example.Apicurrency.inApi;

import com.example.Apicurrency.autApi.AutMain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    /**
     * Получение запроса с параметром "valuta"
     *
     * @param val
     * @return courseResponse
     */
    @RequestMapping("/gif/{valuta}")
    public @ResponseBody  String getValuta(@PathVariable(value = "valuta") String val){
        return AutMain.autMain(val);
        }
}
