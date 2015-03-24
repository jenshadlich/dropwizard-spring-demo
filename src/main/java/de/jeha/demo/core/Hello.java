package de.jeha.demo.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * @author jenshadlich@googlemail.com
 */
public class Hello {

    private long id;

    @Length(max = 3)
    private String payload;

    public Hello() {
    }

    public Hello(long id, String payload) {
        this.id = id;
        this.payload = payload;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getPayload() {
        return payload;
    }
}