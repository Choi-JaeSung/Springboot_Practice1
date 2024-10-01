package practice.sky.aroundhub.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "api/v1/get-api")
public class DeleteController
{
    // http://localhost:8080/api/v1/get-api/delete/{String 값}
    @DeleteMapping(value = "/delete/{variable}")
    public String DeleteVariable(@PathVariable String variable)
    {
        return variable;
    }
}

/*
- 실제 delete 과정은 받은 id 값으로 DB 에서 동일 값을 찾아 지워주는 역할을 부여한다. (여기선 내부는 제외하고 겉만 작동하는지 보기 위함)
 */