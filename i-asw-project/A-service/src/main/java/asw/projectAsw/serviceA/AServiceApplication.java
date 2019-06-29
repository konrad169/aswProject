package asw.projectAsw.serviceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
// import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
// @EnableHystrix
public class AServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AServiceApplication.class, args);
	}
}
