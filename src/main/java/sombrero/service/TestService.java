package sombrero.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestService {

    public void test_aspect() {
        log.info("##### TestService - test_aspect()!!");
    }

}
