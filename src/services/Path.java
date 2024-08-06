package src.services;

public enum Path {
    PATH_TO_DATA_FOR_CUSTOM_COLLECTION("src/resources/dataForCustomCollection");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
