package sombrero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy // AOP 설정. (최상단 패키지에..)
@ServletComponentScan // 필터 설정. (애노테이션 방법.)
@Slf4j // Slf4j 롬북 (스프링부트에 이미 Slf4j와 로그백이 포함되어 있음. 롬북만 의존성 추가해서 사용하면 됨.)
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        log.info("##### logback(lombok) log start!!");
        SpringApplication.run(TestApplication.class, args);
    }

}
