package pe.edu.pucp.msrole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsRoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRoleApplication.class, args);
    }

}
