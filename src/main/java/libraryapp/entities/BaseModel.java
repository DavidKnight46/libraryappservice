package libraryapp.entities;

abstract class BaseModel {
    protected String name;

    public BaseModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
