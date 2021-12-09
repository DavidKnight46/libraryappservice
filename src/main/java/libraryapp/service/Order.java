package libraryapp.service;

public enum Order {

    ASC("asc"),
    DESC("desc");

    private String order;

    Order(String order) {
        this.order = order;
    }

    public String getOrder() {
        return order;
    }
}
