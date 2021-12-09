package libraryapp.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = DeveloperModel.DeveloperModelBuilder.class)
public class DeveloperModel {

    private String name;

    public DeveloperModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class DeveloperModelBuilder {
        private String name;

        public DeveloperModel build() {
            return new DeveloperModel(name);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
