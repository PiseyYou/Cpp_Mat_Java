package test.json;

public class Scale {
    private String width;
    private String height;
    private String bitrate;
    private String iframe;
    private String framerate;

    public Scale() {
    }

    public Scale(String width, String height, String bitrate, String iframe, String framerate) {
        this.width = width;
        this.height = height;
        this.bitrate = bitrate;
        this.iframe = iframe;
        this.framerate = framerate;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getBitrate() {
        return bitrate;
    }

    public void setBitrate(String bitrate) {
        this.bitrate = bitrate;
    }

    public String getIframe() {
        return iframe;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public String getFramerate() {
        return framerate;
    }

    public void setFramerate(String framerate) {
        this.framerate = framerate;
    }

    @Override
    public String toString() {
        return "Scale{" +
                "width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", bitrate='" + bitrate + '\'' +
                ", iframe='" + iframe + '\'' +
                ", framerate='" + framerate + '\'' +
                '}';
    }
}
