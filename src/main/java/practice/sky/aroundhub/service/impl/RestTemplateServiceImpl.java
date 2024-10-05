package practice.sky.aroundhub.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import practice.sky.aroundhub.dto.MemberDTO;
import practice.sky.aroundhub.service.RestTemplateService;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService
{
    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);


    @Override
    public String getAroundHub()
    {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                                      .path("/api/server/around-hub")
                                      .encode()
                                      .build()
                                      .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }


    @Override
    public String getName()
    {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                                      .path("/api/server/name")
                                      .queryParam("name", "SKY")
                                      .encode()
                                      .build()
                                      .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }


    @Override
    public String getName2()
    {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                                      .path("/api/server/path-variable/{name}")
                                      .encode()
                                      .build()
                                      .expand("SKY")   // 여러 개의 값을 넣을 경우 : , 로 구분
                                      .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }


    @Override
    public ResponseEntity<MemberDTO> postDto()
    {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                                      .path("/api/server/member")
                                      .queryParam("name", "SKY")
                                      .queryParam("email", "email@email.com")
                                      .queryParam("organization", "org")
                                      .encode()
                                      .build()
                                      .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("SKY!");
        memberDTO.setEmail("email@email.com!");
        memberDTO.setOrganization("org!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }


    @Override
    public ResponseEntity<MemberDTO> addHeader()
    {
        URI uri = UriComponentsBuilder.fromUriString("http://localhost:9090")
                                      .path("/api/server/add-header")
                                      .encode()
                                      .build()
                                      .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("SKY");
        memberDTO.setEmail("email@email.com");
        memberDTO.setOrganization("org");

        RequestEntity<MemberDTO> requestEntity = RequestEntity.post(uri).header("around-header", "Around Hub Studio").body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity = restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}

/*
- header : 보안 인증키를 header 에 넣어서 보내거나 등 여러 곳에 쓰인다.
 */