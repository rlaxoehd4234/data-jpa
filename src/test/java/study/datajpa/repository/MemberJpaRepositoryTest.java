package study.datajpa.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired MemberJpaRepository memberJpaRepository;


    @Test
    public void testMember() {
        Member member = new Member("memberA");

        Member savedMember = memberJpaRepository.save(member);
        Member findedMember = memberJpaRepository.find(member.getId());

        Assertions.assertEquals(savedMember.getId(), savedMember.getId());
        org.assertj.core.api.Assertions.assertThat(savedMember.getId()).isEqualTo(findedMember.getId());
    }

}