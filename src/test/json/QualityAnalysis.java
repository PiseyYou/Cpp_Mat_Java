package test.json;

public class QualityAnalysis {
    private String update;

    public QualityAnalysis() {
    }

    public QualityAnalysis(String update) {
        this.update = update;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    @Override
    public String toString() {
        return "QualityAnalysis{" +
                "update='" + update + '\'' +
                '}';
    }
}
