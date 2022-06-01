package at.ac.fhcampuswien.Enums;

public enum Endpoint {
    EVERYTHING("everything"),
    TOP_HEADLINES("top-headlines"),
    SOURCES("sources"),
    TEST("test");

    private String value;

    public String getValue() {
        return value;
    }

    Endpoint(String v) { this.value = v;}
}
