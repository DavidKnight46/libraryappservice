package libraryapp.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = PublisherModel.PublisherModelBuilder.class)
public class PublisherModel {

    private final String name;

    public PublisherModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class PublisherModelBuilder {

        private String name;

        public PublisherModel build(){
            return new PublisherModel(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
