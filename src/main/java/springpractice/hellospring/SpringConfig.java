package springpractice.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springpractice.hellospring.repository.MemberRepository;
import springpractice.hellospring.service.MemberService;

// 자바 코드로 직접 스프링 빈 등록하는 방법
@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    */
    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }

    /*
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
        return
    }
    */

}
