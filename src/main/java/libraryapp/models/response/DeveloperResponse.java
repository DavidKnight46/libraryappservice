package libraryapp.models.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeveloperResponse.DeveloperModelBuilder.class)
public class DeveloperResponse {

    private final String name;

    public DeveloperResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class DeveloperModelBuilder {
        private String name;

        public DeveloperResponse build() {
            return new DeveloperResponse(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
