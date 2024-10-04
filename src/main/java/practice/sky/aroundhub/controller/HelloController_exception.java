package practice.sky.aroundhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController_exception
{
    private final Logger LOGGER = LoggerFactory.getLogger(HelloController_exception.class);


    // http://localhost:8080/hello-exception
    @RequestMapping("/hello-exception")
    public String hell()
    {
        return "Hello World";
    }


    // http://localhost:8080/exception
    @PostMapping(value = "/exception")
    public void exceptionTest() throws Exception
    {
        throw new Exception();
    }


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e)
    {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }
}

/*
- ExceptionHandler 우선순위 : 전역 ExceptionHandler(exception.AroundHubExceptionHandler) < Controller 내의 ExceptionHandler(controller.HelloController_exception)
  >> 전역으로 설정한 Handler 보다 해당 Controller 내의 Handler 가 우선 호출 (Controller 내 ExceptionHandler 호출)
    >>> Controller 내의 Handler 를 제거하면 전역으로 설정한 Handler 가 호출 (Advice 내 ExceptionHandler 호출)
 */