package libraryapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PublisherModel {

    @JsonProperty
    private final String name;

    public PublisherModel(String name) {
        this.name = name;
    }
}
