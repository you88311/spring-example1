package springpractice.hellospring.repository;

import springpractice.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }


    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        /*get()은 return 값을 optional로 준 경우 optional말고
        optional로 감싼 객체를 return해줌
        Assertions.assertEquals(member, null); 이것도 가능한데 이건 뭐가 actual이고 뭐가 expected인지 헷갈림
        */
        assertThat(member).isEqualTo(result);
        /*assertThat은 검증하는 메서드
         * Assertions보다는 assertThat은 actual, expected이 직관적으로 뭔지 확인하기 쉽기에 이걸 요즘 많이 사용
         */
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring1");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }

}
