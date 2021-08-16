package mk.ukim.finki.icareapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class IcareAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcareAppApplication.class, args);
    }

}
