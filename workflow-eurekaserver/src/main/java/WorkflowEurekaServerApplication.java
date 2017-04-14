/**
 * Created by tile on 4/14/2017.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class WorkflowEurekaServerApplication {

    public  static void main(String[]args){
        SpringApplication.run(WorkflowEurekaServerApplication.class, args);

    }
}
