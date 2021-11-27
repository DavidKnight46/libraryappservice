package libraryapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


//@Builder
@NoArgsConstructor
public class DeveloperModelBuilder {

    @JsonProperty
    public String name;

}
