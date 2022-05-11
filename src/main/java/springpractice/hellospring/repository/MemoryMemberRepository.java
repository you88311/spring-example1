package springpractice.hellospring.repository;

import org.springframework.stereotype.Repository;
import springpractice.hellospring.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; //0,1,2 같이 key값 생성해주는

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //회원이 입력하는 id아님. 내부적 회원id
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        /*이런식으로 Optional주면 null인 경우 client단에서 별도로
        * 조치할 수 있는 기능 제공*/
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        /*Java8에 추가된 람다식..Map의 member중에 String name과 이름이
        * 동일한 경우 그 값을 반환 없으면 Null 반환*/
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
