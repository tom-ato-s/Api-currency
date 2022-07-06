package com.example.Apicurrency;

import com.example.Apicurrency.autApi.AutMain;
import feign.Param;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URISyntaxException;

import static com.example.Apicurrency.autApi.AutMain.*;

@Controller
public class HomeController {
    @RequestMapping("/gif/{valuta}")
    public @ResponseBody  String greeting(@Param("valuta") String valuta) throws URISyntaxException {
        String s = AutMain.autMain("RUB");
        return s;
        }
}
