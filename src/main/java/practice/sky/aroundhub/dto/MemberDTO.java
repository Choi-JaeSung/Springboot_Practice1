package practice.sky.aroundhub.dto;

public class MemberDTO
{
    private String name;
    private String email;
    private String organization;



    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public String getEmail()
    {
        return email;
    }


    public void setEmail(String email)
    {
        this.email = email;
    }


    public String getOrganization()
    {
        return organization;
    }


    public void setOrganization(String organization)
    {
        this.organization = organization;
    }


    @Override
    public String toString() {
        return "MemberDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}

/*
- IntelliJ 에서는 Alt + Insert 로 get, set, toString 등 여러 기본 Methods 를 자동 입력 가능 (Intellij 의 Generator 기능)
 */