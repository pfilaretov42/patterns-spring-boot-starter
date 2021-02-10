package pro.filaretov.spring.patterns.blackdots.starter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/api/v1/blackdots")
public class BlackDotsController {

    @GetMapping("/random")
    public String getRandom() {
        return "c4";
    }
}
