package technancy.javatraining.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;


public class Product {
    private long id;

    @Length(max = 3)
    private String description;

    public Product() {
        // Jackson deserialization
    }

    public Product(long id, String description) {
        this.id = id;
        this.description = description;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getDescription() {
        return description;
    }
}
