package br.com.wildrimak.learningconsul;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.naming.ServiceUnavailableException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class LearningConsulApplication {

	@Value("${hello-world}")
	private String variable;

	@Value("${variable}")
	private String other;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/hello-world")
	public String home() {
		return "Hello World " + this.variable + ": " + this.other;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearningConsulApplication.class, args);
	}

	public String serviceUrl() {
		List<ServiceInstance> list = discoveryClient.getInstances("hello");
		if (list != null && list.size() > 0 ) {
			return list.get(0).getUri().toString();
		}
		return null;
	}

}
