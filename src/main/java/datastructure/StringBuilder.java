package datastructure;

public class StringBuilder {
    private String data;

    public StringBuilder() {
        this.data = "";
    }

    public StringBuilder(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }

    public StringBuilder append(StringBuilder builder1) {
        return null;
    }
}
