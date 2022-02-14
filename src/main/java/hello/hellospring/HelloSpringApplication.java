package hello.hellospring; //해당 패키지부터 하위 폴더만 스프링이 컴포넌트 스캔하여 스프링빈으로 등록

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
