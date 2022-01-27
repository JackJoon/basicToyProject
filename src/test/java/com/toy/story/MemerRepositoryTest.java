package com.toy.story;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemerRepositoryTest {

    @Autowired MemberRepository memberRepository;

    /**
     * Tip
     * Gradle을 활용하여 Junit 실행 중 Could not complete execution for Gradle Test Executor 3 에러가 나왔을 때는
     * Settings -> build, Exception,Deployment -> Gradle -> gradle Project 탭의 Build and run using/ Run tests using을 Intellij IDEA 로 변경 하면 된디ㅏ.
     *
     *
     *
     * @throws Exception
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testMember() throws Exception {
        //given
        Member member= new Member();
        member.setUserName("memeberA");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.find(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());
        Assertions.assertThat(findMember).isEqualTo(member);
        //같은 영속성 컨텍스트에서 같은 Entity의 ID가 같을 경우에는 True 이다.
        System.out.println("fuindMember == member " + (findMember == member));
    }
}