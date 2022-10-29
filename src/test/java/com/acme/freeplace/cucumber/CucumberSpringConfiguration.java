package com.acme.freeplace.cucumber;

import com.acme.freeplace.FreePlaceApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = FreePlaceApplication.class,
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = FreePlaceApplication.class,loader = SpringBootContextLoader.class)
public class CucumberSpringConfiguration {
}
