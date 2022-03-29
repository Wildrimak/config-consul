package br.com.wildrimak.learningconsul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class LearningConsulApplication {

    @Value("${pronoun}")
    private String pronoun;

    @Value("${yourName}")
    private String yourName;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/hello-world")
    public String home() {
        return "Olá " + this.pronoun + " " + this.yourName;
    }

    public static void main(String[] args) {
        SpringApplication.run(LearningConsulApplication.class, args);
    }

}
