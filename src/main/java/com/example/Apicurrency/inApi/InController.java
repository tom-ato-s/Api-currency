package com.example.Apicurrency.inApi;

import com.example.Apicurrency.autApi.AutMain;
import feign.Param;
import feign.RequestLine;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

import static com.example.Apicurrency.autApi.AutMain.*;

@RestController
//@RequestMapping("/gif")
 public class InController {
//    public interface InController {
//    private final String sharedKey = "SHARED_KEY";
//
//    private static final String SUCCESS_STATUS = "success";
//    private static final String ERROR_STATUS = "error";
//    private static final int CODE_SUCCESS = 100;
//    private static final int AUTH_FAILURE = 102;

//
//    @RequestLine("GET /gif/{valuta}")
//    String getGif(@Param("valuta") String valuta) throws URISyntaxException {
//      String s = autMain(valuta);
//        return s;
//    }





    // отправка статуса ок

//  @GetMapping ("gif/{valuta}")
//    public ResponseGif getGif(@PathVariable String valuta) {
//      return new ResponseGif("https://giphy.com/search/broke");
//  }

//    @GetMapping
//    public BaseResponse showStatus() {
//        return new BaseResponse(SUCCESS_STATUS, 1);
//    }
//    //отправка валюты
//    public BaseResponse getGif(@RequestParam(value = "valuta") String valuta, @RequestBody InRequest request) {
//
//        final BaseResponse response;
//
//        if (sharedKey.equalsIgnoreCase(valuta)) {
//            String rate = request.getRate();
//
//            // Process the request
//            // ....
//            // Return success response to the client.
//            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
//        } else {
//            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
//        }
//        return response;
//    }

}
