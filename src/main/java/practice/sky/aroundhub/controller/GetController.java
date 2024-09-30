package practice.sky.aroundhub.controller;

import org.springframework.web.bind.annotation.*;
import practice.sky.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")   // GetController Class 의 Method 사용시 앞에 URL 추가 (v1 : version -> 해당 형식으로 버전 관리도 가능)
public class GetController
{
    // http://localhost:8080/api/v1/get-api/hello
    @GetMapping(value = "/hello")
    public String getHello()
    {
        return "Hello World";
    }


    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value = "/name")
    public String getName()
    {
        return "SKY";
    }


    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable)   // {variable} 과 String variable 이름이 동일할 때 사용
    {
        return variable;
    }


    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value = "/variable2/{variable}")
    public String getVariable2(@PathVariable(value = "variable") String var)   // {variable} 과 String var 이름이 동일 X 사용 >> PathVariable("{variable}") 를 var 로 Mapping 가능
    {
        return var;
    }


    // http://localhost:8080/api/v1/get-api/request1?name=SKY&email=email@email.com&organization=org
    @GetMapping(value = "request1")
    public String getRequestParam1(@RequestParam String name,
                                   @RequestParam String email,
                                   @RequestParam String organization)   // Param 개수가 정해질 때 사용
    {
        return name + " " + email + " " + organization;
    }


    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2...
    @GetMapping(value = "/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param)   // parma 개수를 모를 때 사용
    {
        StringBuilder sb = new StringBuilder();

        param.forEach((key, value) -> sb.append(key + " : " + value + "\n"));

        return sb.toString();
    }


    // http://localhost:8080/api/v1/get-api/request3?name=SKY&email=email@email.com&organization=org
    @GetMapping(value = "/request3")
    public String getRequestParam3(MemberDTO memberDTO)
    {
        return memberDTO.toString();
    }
}

/*
- @PathVariable({variable}) : Overloading 과 같이 같은 기능을 하는 Method 위한 Mapping 방법 (ex: 회원가입시 필수 X 부분을 입력시 처리를 위해 Overloading 되었을 때 Mapping 가능)
- @RequestParam : param 개수가 정해지면 수만큼 추가해주면 되겠지만, 모를 때에는 개수만큼 담을 자료구조를 제공한다 (ex: Map<>, ...)
 */