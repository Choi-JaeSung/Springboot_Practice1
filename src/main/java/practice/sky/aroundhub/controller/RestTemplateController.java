package practice.sky.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.sky.aroundhub.dto.MemberDTO;
import practice.sky.aroundhub.service.RestTemplateService;

@RestController
@RequestMapping(value = "/api/rest-template")
public class RestTemplateController
{
    RestTemplateService restTemplateService;


    @Autowired
    public RestTemplateController(RestTemplateService restTemplateService)
    {
        this.restTemplateService = restTemplateService;
    }


    // http://localhost:8080/api/rest-template/around-hub
    @GetMapping(value = "/around-hub")
    public String getAroundHub()
    {
        return restTemplateService.getAroundHub();
    }


    // http://localhost:8080/api/rest-template/name
    @GetMapping(value = "/name")
    public String getName()
    {
        return restTemplateService.getName();
    }


    // http://localhost:8080/api/rest-template/name2
    @GetMapping(value = "/name2")
    public String getName2()
    {
        return restTemplateService.getName2();
    }


    // http://localhost:8080/api/rest-template/dto
    @PostMapping(value = "/dto")
    public ResponseEntity<MemberDTO> postDto()
    {
        return restTemplateService.postDto();
    }


    // http://localhost:8080/api/rest-template/add-header
    @PostMapping(value = "/add-header")
    public ResponseEntity<MemberDTO> addHeader()
    {
        return restTemplateService.addHeader();
    }
}
