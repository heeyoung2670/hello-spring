package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//컴포넌트 스캔말고 직접 스프링 컨테이너에 등록하는 방법
@Configuration
public class SpringConfig {

/*    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
*/

/*    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

/*    @Bean
    //다른 repository로 변경할 때 다른 코드를 손대지 않아도 되므로 직접 스프링 빈 설정이 편함
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
*/
}