package libraryapp.models.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = PublisherResponse.PublisherModelBuilder.class)
public class PublisherResponse {

    private final String name;

    public PublisherResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class PublisherModelBuilder {

        private String name;

        public PublisherResponse build(){
            return new PublisherResponse(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
