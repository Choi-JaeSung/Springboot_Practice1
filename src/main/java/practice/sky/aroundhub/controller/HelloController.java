package practice.sky.aroundhub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController   // 해당 Class 에 Controller 기능 부여
public class HelloController
{
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)   // 기존 URL + /hello 로 해당 Method 실행 | method = RequestMethod.(GET, POST, ...) 로 Method 에 기능 설정 >> 예전방식
    @GetMapping("hello")   // 해당 Method 에 GET 기능 및 URL + /hello 로 실행 가능 >> 신규방식
    public String hello()
    {
        return "Hello World";
    }
}

/*
- Springboot 는 기본적으로 코드 수정 후 즉시반영 X -> 서버 다시 실행 >>> Django 처럼 Debug 모드 있는 찾아볼 예정(코드 수정 후 바로 서버 재시작)
- Springboot 기본 URL : http://localhost:8080 -> http://(IP):(Port) >> Django와 같음

- @RestController : Controller 기능 부여 (Controller 생성시 *필수*)
- @GetMapping("URL") : 해당 Method 에 GET 기능 부여 및 기존 URL + /URL 로 실행 가능
 */