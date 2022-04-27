package at.ac.fhcampuswien;

public enum Endpoint {
    EVERYTHING("everything"),
    TOP_HEADLINES("top-headlines"),
    SOURCES("sources");

    private String value;

    public String getValue() {
        return value;
    }

    Endpoint(String v) { this.value = v;}
}
