package test.json;

public class Stream {
    private String source;
    private Scale scale;

    public Stream() {
    }

    public Stream(String source, Scale scale) {
        this.source = source;
        this.scale = scale;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Scale getScale() {
        return scale;
    }

    public void setScale(Scale scale) {
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "StreamClass{" +
                "source='" + source + '\'' +
                ", scale=" + scale +
                '}';
    }
}
