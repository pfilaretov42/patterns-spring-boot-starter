package pro.filaretov.spring.patterns.blackdots.starter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.filaretov.spring.patterns.blackdots.starter.autoconfigure.BlackDotsProperties;

/**
 *
 */
@RestController
@RequestMapping("/api/v1/blackdots")
@Slf4j
public class BlackDotsController {

    public BlackDotsController(BlackDotsProperties properties) {
        log.info("BlackDotsController created with properties: {}", properties);
    }

    @GetMapping("/random")
    public String getRandom() {
        return "c4";
    }
}
