package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.Optional;

//ctrl + shift + T -> TEST 파일 자동으로 생성가능
@Transactional
public class MemberService {

    //private final MemberRepository memberRepository = new MemoryMemberRepository();

    private final MemberRepository memberRepository;
    //dependency injection(DI)
    //외부에서 repository를 넣어줌

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원 X
        //ctrl + alt + V -> return 자동으로 해줌
        //ctrl + alt + shift + T -> Extract Method 선택 : Method로 뽑을 수 있음
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> { //값이 있으면 로직이 동작
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
