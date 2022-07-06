/*
Controller для входящих запросов на сервер
получает валюту
возвращает gif
 */

package com.example.Apicurrency.inApi;

import com.example.Apicurrency.autApi.AutMain;
import feign.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class HomeController {
    @RequestMapping("/gif/{valuta}")
    public @ResponseBody  String greeting(@PathVariable(value = "valuta") String val) throws URISyntaxException, IOException {
        String s = AutMain.autMain(val);
        return s;
        }
}
