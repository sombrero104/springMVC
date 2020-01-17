package sombrero;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@Slf4j
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        log.info("##### logback(lombok) log start!!");
        SpringApplication.run(TestApplication.class, args);
    }

}
