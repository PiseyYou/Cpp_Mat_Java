package test.json;

public class IntelligentAnalysis {
    private String Item_Active;
    private String Interval;

    public IntelligentAnalysis() {
    }

    public IntelligentAnalysis(String item_Active, String interval) {
        this.Item_Active = item_Active;
        this.Interval = interval;
    }

    public String getItem_Active() {
        return Item_Active;
    }

    public void setItem_Active(String item_Active) {
        Item_Active = item_Active;
    }

    public String getInterval() {
        return Interval;
    }

    public void setInterval(String interval) {
        Interval = interval;
    }

    @Override
    public String toString() {
        return "IntelligentAnalysis{" +
                "Item_Active='" + Item_Active + '\'' +
                ", Interval='" + Interval + '\'' +
                '}';
    }
}
