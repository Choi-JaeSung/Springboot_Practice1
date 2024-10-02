package practice.sky.aroundhub.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO_Lombok
{
    private String name;
    private String email;
    private String organization;
}

/*
- Lombok : 기본적으로 작성되는 method (get, set, toString, Constructor, ...) 들을 annotation(@~..) 으로 작성하여 code 를 간소화
  >> 성능에 영향을 줄 수도 있기 떄문에 프로젝트마다 고려 후 사용
- @Getter : Class 속성별 Get method 자동 생성
- @Setter : Class 속성별 Set method 자동 생성
- @ToString : Class 속성들에 대한 ToString method 자동 생성
 */