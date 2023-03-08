package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 스프링 데이터 JPA 가 구현체를 만들어서 구현체를 주입 해주는 것이다.
    // 순수 JPA가 아닌 DataJpa가 기본 CRUD 를 지원해준다.
    // 굳이 반복되는 CRUD 코드들을 짤 필요없이 다해준다. 필요시에 JPQL 을 추가하자. 
    public List<Member> findMemberByAge(int age);

    @Query("select m from Member m where m.name = :username and m.age = :age")
    List<Member> findUser(@Param("name") String username, @Param("age") int age);

    @Query("select m.name from Member m")
    List<String> findUsernameList();

    @Query("select m from Member m")
    Page<Member> findAllMember(Pageable pageable);
    
}
