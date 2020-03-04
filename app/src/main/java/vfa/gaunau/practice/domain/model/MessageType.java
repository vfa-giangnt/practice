package vfa.gaunau.practice.domain.model;

public enum MessageType {
    TYPE_1("1"),
    TYPE_2("2"),
    TYPE_3("3"),
    TYPE_4("4");

    private String code;

    public String getCode() {
        return this.code;
    }

    MessageType(String code) {
        this.code = code;
    }
}
