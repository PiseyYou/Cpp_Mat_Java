package web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class servletPost {
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        String sr= HttpRequest.sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
//        String sr= sendPost("http://localhost:6144/Home/RequestPostString", "key=123&v=456");
//        JSONObject jsonObj = (JSONObject) JSON.toJSON("{\"Stream_Input\":{\"Input_Source\":\"rtsp://192.168.1.110/live5\",\"Input_Scale\":{\"bitrate\":\"4096\",\"framerate\":\"25\",\"height\":\"1080\",\"iframe\":\"50\",\"width\":\"1920\"}},\"AIBoard_No\":\"1234123412332\",\"Stream_Output_Low\":{\"Output_Scale\":{\"bitrate\":\"32\",\"framerate\":\"25\",\"height\":\"288\",\"iframe\":\"50\",\"width\":\"352\"},\"Output_Source\":\"rtmp://192.168.1.103/live/room85\"},\"IntelligentAnalysis_Task\":{\"interval\":\"5\",\"item_Active\":\"00000000\"},\"IS_AIPushStream\":\"1\",\"IS_Intelligent\":\"0\",\"QualityAnalysis_Task\":{\"update\":\"update\"},\"IS_AIQuality\":\"0\",\"AITask_No\":\"asdr343-srqeef223-qerq85\"}");
        Map<String,Object> demo = new HashMap<>();
        demo.put("AITask_No","asdr343-srqeef223-qerq84");
        demo.put("IS_AIPushStream","1");
        demo.put("IS_AIQuality","1");
        demo.put("IS_Intelligent","0");
        JSONObject jsonObj = new JSONObject(demo);
        String test = jsonObj.toString();
        System.out.println(test);

        String sr= sendPost("http://192.168.1.105:8088/service/video.SendAIBoardTaskStatus", test);
        System.out.println(sr);
    }
}
