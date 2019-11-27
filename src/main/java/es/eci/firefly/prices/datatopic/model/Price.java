package es.eci.firefly.prices.datatopic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Price implements Serializable {

    private String item;
    private String company;
    private String commercialCenterCode;

    private Double value;

    @JsonProperty(defaultValue = "null")
    private Date priceUpdateDate;

    @JsonProperty(defaultValue = "null")
    private Date priceCreationDate;

}

