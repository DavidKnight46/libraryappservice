package libraryapp.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class GameModelRequest {

    @JsonProperty
    private String gameName;

    @JsonProperty
    private int rating;

    @JsonProperty
    private LocalDate releaseDate;

    @JsonProperty
    private int pubId;

    @JsonProperty
    private int devId;

    @JsonProperty
    private int userId;

    public String getGameName() {
        return gameName;
    }

    public int getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public int getPubId() {
        return pubId;
    }

    public int getDevId() {
        return devId;
    }

    public int getUserId() {
        return userId;
    }
}
