package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    //Test는 모두 독립적으로 설계해야함 -> Test한 후 데이터 clear
    MemoryMemberRepository repository = new MemoryMemberRepository();

    //메소드 실행이 끝날 때마다 동작
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

        //Assertions.assertEquals(member, result);

        //option에서 static import로 바꾸면 Assertions 안써도 됨
        assertThat(member).isEqualTo(result); //출력하지 않고 값이 맞는지 확인
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + F6 하면 자동으로 rename 가능
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

        Member meber2 = new Member();
        meber2.setName("spring2");
        repository.save(meber2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }


}
