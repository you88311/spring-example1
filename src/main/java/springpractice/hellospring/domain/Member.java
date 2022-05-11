package springpractice.hellospring.domain;

public class Member {

    private Long id;
    private String name;

    //아래는 getter, setter로 자동 생성함
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
