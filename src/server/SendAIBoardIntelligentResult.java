package server;

import Decoder.BASE64Decoder;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.imgcodecs.Imgcodecs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.bytedeco.opencv.global.opencv_highgui.waitKey;
import static org.opencv.highgui.HighGui.imshow;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;

@WebServlet("/service/video.SendAIBoardIntelligentResult")
public class SendAIBoardIntelligentResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String Addr = request.getRemoteAddr();
        String sendURI = request.getRequestURI();
        System.out.println("URL:" + Addr + sendURI);

        StringBuilder jsonString = new StringBuilder();
        BufferedReader reader = request.getReader();
        try {
            String line;
            while ((line = reader.readLine())!= null) {
                jsonString.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("接收图片异常");
        }
        finally {
            reader.close();
        }

        //对字符串进行序列化
        JSONObject jsonObject = JSON.parseObject(jsonString.toString());
        System.out.println(jsonObject);

        //获取json对应值对
        JSONArray mrl = jsonObject.getJSONArray("result_list");
        JSONObject srl = mrl.getJSONObject(0);
        JSONArray ssrl = srl.getJSONArray("result_list");


        //对AI事件进行分类保存
        HashMap<String, String> Tasklist = new HashMap<String, String>();
        Tasklist.put("1","CarPlate");
        Tasklist.put("2","TrafficJam");
        Tasklist.put("3","HighwayPerson");
        Tasklist.put("4","MaintenanceEvents");
        Tasklist.put("5","AnimalDetector");
        Tasklist.put("6","FlowStatistics");
        Tasklist.put("7","TrafficAccident");

        //创建对应文件夹
        String basePath = "/home/pisey/Downloads/picsave/";
        File basedir = new File(basePath);
        Set<String> keys = Tasklist.keySet();
        for (String key : keys) {
            String value = Tasklist.get(key);
            File TaskSaveDir = new File(basePath+value);
            if(!TaskSaveDir.exists()) {
                TaskSaveDir.mkdir();
            }
        }


        for (int i =0; i<ssrl.size();i++) {
            JSONObject event = ssrl.getJSONObject(i);
            String pic = event.getString("pic");
//            System.out.println("pic:" +pic);
//            System.out.println("pic的长度为:"+pic.length());
//
            String filename = event.getString("event");
            String time = event.getString("time");
            System.out.println("时间为:"+time +",的图片string大小为"+pic.length());
////            FileOutputStream fos = new FileOutputStream("/home/pisey/Downloads/picsave/" + filename + "_" +time +".png");
//            String picSave = "/home/pisey/Downloads/picsave/" + filename + "_" +time +".png";


            //对base64传输的图片进行解码
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(pic);
            int k = 0;
            if (null == bytes || 0 == bytes.length)
                System.out.println("获取到图片信息为0"); ;
            for (; k < bytes.length; k++) {
                if (bytes[k] < 0)
                    bytes[k] +=256;
            }
            System.out.println("获取到的图片的长度为:" + k);


            //对时间进行序列化
//            SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//            SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String time1 = time+"000";
            Date date=new Date(Long.parseLong(time+"000"));
            SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
//            String htime = myFmt.format(date);//
            String htime = myFmt.format(date);
            System.out.println("序列化后的时间为:" + htime);

            FileOutputStream fos = new FileOutputStream(basePath + Tasklist.get(filename) + "/" + htime +".png");
            System.out.println("保存的路径为:"+basePath + Tasklist.get(filename) + "_" +htime +".png");
            fos.write(bytes);

//            System.load("/usr/bin/libopencv_java346.so");
//            imshow("显示原始图像", MpicSave);
//            imshow("显示原始图像", testpic);
//            waitKey(0);
//
//            // 生成jpeg图片
//            OutputStream out = new FileOutputStream("/home/pisey/Downloads/picsave/" + filename + "_" +time +".png");
//            out.write(bytes);
//            out.flush();
//            out.close();
//
        }

        Feedback fmsg = new Feedback("200", "指令处理成功");
        JSONObject jsonObj = (JSONObject) JSON.toJSON(fmsg);
//
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObj.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
