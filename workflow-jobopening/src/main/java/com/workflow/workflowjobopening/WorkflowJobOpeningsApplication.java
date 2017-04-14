

package com.workflow.workflowjobopening;

        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class WorkflowJobOpeningsApplication  {

    public static void main(String[] args) {
        SpringApplication.run(WorkflowJobOpeningsApplication.class, args);
    }
}

@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
