package es.eci.firefly.prices.datatopic;

import es.eci.firefly.prices.datatopic.service.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
@EnableScheduling
public class PricesDataTopicApplication implements CommandLineRunner {

    private final Consumer consumer;

    @Autowired
    PricesDataTopicApplication(Consumer consumer) {
        this.consumer = consumer;
    }

    public static void main(String[] args) {
        SpringApplication.run(PricesDataTopicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.",
                Arrays.toString(args));

    }
}
