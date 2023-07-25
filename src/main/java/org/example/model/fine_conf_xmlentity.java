package org.example.model;

public class fine_conf_xmlentity {
    private String id ;
    private String value ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "fine_conf_xmlentity{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
