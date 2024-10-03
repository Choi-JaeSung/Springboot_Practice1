package practice.sky.aroundhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController_log
{
    private final Logger LOGGER = LoggerFactory.getLogger(HelloController_log.class);


    // http://localhost:8080/hello-log
    @RequestMapping(value = "/hello-log")
    public String hello()
    {
        return "Hello World!";
    }


    // http://localhost:8080/log-test
    @PostMapping(value = "log-test")
    public void logTest()
    {
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }
}
