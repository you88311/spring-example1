package springpractice.hellospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springpractice.hellospring.repository.JdbcTemplateMemberRepository;
import springpractice.hellospring.repository.MemberRepository;
import springpractice.hellospring.repository.MemoryMemberRepository;
import springpractice.hellospring.service.MemberService;

import javax.sql.DataSource;

// 자바 코드로 직접 스프링 빈 등록하는 방법
@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
