package libraryapp.dto;

public class GameDTO {

    private int id;
    private String gameName;
    private Integer rating;
    private String releaseDate;
    private String imageUrl;
    private boolean isPreOrdered;

    public GameDTO(int id, String gameName, Integer rating, String releaseDate, String imageUrl, boolean isPreOrdered) {
        this.id = id;
        this.gameName = gameName;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.imageUrl = imageUrl;
        this.isPreOrdered = isPreOrdered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public boolean isPreOrdered() {
        return isPreOrdered;
    }

    public void setPreOrdered(boolean preOrdered) {
        isPreOrdered = preOrdered;
    }
}
