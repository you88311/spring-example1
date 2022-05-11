package springpractice.hellospring.repository;

import springpractice.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    /*optional은 java8에 추가된 기능
    * 해당 값이 null인 경우 추가적 기능 제공
    */
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

}

