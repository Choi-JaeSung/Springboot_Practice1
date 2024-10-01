package practice.sky.aroundhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.sky.aroundhub.dto.MemberDTO;

import java.util.Map;

@RestController("SKY")
@RequestMapping(value = "/api/v1/put-api")
public class PutController
{
    // http://localhost:8080/api/v1/put-api/default
    @PutMapping(value = "/default")
    public String putMethod()
    {
        return "Hello World!";
    }


    // http://localhost:8080/api/v1/put-api/member
    @PutMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData)
    {
        StringBuilder sb = new StringBuilder();

        postData.forEach((key, value) -> sb.append(key + " : " + value + "\n"));

        return sb.toString();
    }


    // http://localhost:8080/api/v1/put-api/member1
    @PutMapping(value = "/member1")
    public String postMemberDto1(@RequestBody MemberDTO memberDTO)
    {
        return memberDTO.toString();
    }


    // http://localhost:8080/api/v1/put-api/member2
    @PutMapping(value = "/member2")
    public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO)
    {
        return memberDTO;
    }


    // http://localhost:8080/api/v1/put-api/member3
    @PutMapping(value = "/member3")
    public ResponseEntity<MemberDTO> postMemberDto3(@RequestBody MemberDTO memberDTO)
    {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
    }
}

/*
- @RestController(value = "String") : 기존 localhost 를 String 로 변경 (ex: localhost:8080 -> SKY:8080)

- return MemberDTO.toString() : String 의 형태로 반환
- return MemberDTO : Json 의 형태로 반환
  >> String 형태처럼 임의로 변경한 형태가 아닌 정해진 형식인 Json 같이 반환하는 것이 client, server 등 처리하기 편해서 협업에 좋다

- ResponseEntity : 기존은 결과 코드를 200이라면 HttpStatus. 에 맞는 번호를 코드로 반환한다
  >> 각각 상황에 따라 정해진 번호가 있기 때문에 상황 처리에 편하다.
 */