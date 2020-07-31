package domain;

public class TaskStatus {
    private String AITask_no;
    private String Stream_Output_status;
    private String QualityAnalysis_status;
    private String IntelligentAnalysis_status;
    private String msg;

    public TaskStatus() {
    }

    public TaskStatus(String AITask_no, String stream_Output_status, String qualityAnalysis_status, String intelligentAnalysis_status, String msg) {
        this.AITask_no = AITask_no;
        this.Stream_Output_status = stream_Output_status;
        this.QualityAnalysis_status = qualityAnalysis_status;
        this.IntelligentAnalysis_status = intelligentAnalysis_status;
        this.msg = msg;
    }

    public String getAITask_no() {
        return AITask_no;
    }

    public void setAITask_no(String AITask_no) {
        this.AITask_no = AITask_no;
    }

    public String getStream_Output_status() {
        return Stream_Output_status;
    }

    public void setStream_Output_status(String stream_Output_status) {
        Stream_Output_status = stream_Output_status;
    }

    public String getQualityAnalysis_status() {
        return QualityAnalysis_status;
    }

    public void setQualityAnalysis_status(String qualityAnalysis_status) {
        QualityAnalysis_status = qualityAnalysis_status;
    }

    public String getIntelligentAnalysis_status() {
        return IntelligentAnalysis_status;
    }

    public void setIntelligentAnalysis_status(String intelligentAnalysis_status) {
        IntelligentAnalysis_status = intelligentAnalysis_status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
