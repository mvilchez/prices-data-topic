package es.eci.firefly.prices.datatopic.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.eci.firefly.prices.datatopic.model.Price;
import es.eci.firefly.prices.datatopic.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@Slf4j
public class Consumer {

    private static final String TOPIC = "prices";
    private final ObjectMapper objectMapper;

    Consumer() {
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = TOPIC, groupId = "group_id")
    public void consume(String message) throws IOException {
        Price priceLeido = objectMapper.readValue(message, Price.class);
        // Transformamos a euros
        priceLeido.setValue(priceLeido.getValue() / 166.386);
        // Actualizamos la fecha
        priceLeido.setPriceUpdateDate(DateUtils.asDate(LocalDateTime.now()));

        log.info(String.format("$$ -> Consumed & Transformed Message Price -> %s", priceLeido));
    }
}