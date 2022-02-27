package libraryapp.service;

public enum SortBy {

    NAME("name"),
    RATING("rating"),
    RELEASE_DATE("release_date");

    private String sortBy;

    SortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortBy() {
        return sortBy;
    }

    @Override
    public String toString() {
        return sortBy;
    }
}
