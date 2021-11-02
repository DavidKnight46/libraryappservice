package libraryapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@Setter
@JsonSerialize
public class DeveloperModel {

    @JsonProperty
    private final String name;

    public DeveloperModel(String name) {
        this.name = name;
    }

}
