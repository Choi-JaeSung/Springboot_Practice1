package practice.sky.aroundhub.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.sky.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class PostController
{
    // http://localhost:8080/api/v1/post-api/default
    @PostMapping(value = "/default")
    public String postMethod()
    {
        return "Hello World";
    }


    // http://localhost:8080/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, String> postData)
    {
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> sb.append(key + " : " + value + "\n"));

        return sb.toString();
    }


    // http://localhost:8080/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDTO memberDTO)
    {
        return memberDTO.toString();
    }
}

/*
- @RequestBody : Post 에서 param 의 정확한 개수를 알 수 없어서 Class 로 받을 때에 사용함 (Body 는 Json 형식 많이 사용)
  >> 1. Get 에서는 URL + ?key=value&... 형식으로 사용
     2. Post 에서는 Body 에 key, value 를 넣어서 사용 (ex: json 형식 ({ "key" : "value", ...}))
     >>> Get 에서는 사용할 필요 X (Get 과 Post 에서의 차이점)
 */