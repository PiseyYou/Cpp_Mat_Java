package test;

import com.alibaba.fastjson.JSONObject;
import test.json.IntelligentAnalysis;
import test.json.QualityAnalysis;
import test.json.Scale;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class readJson {

    public static String readJsonFile(String fileName) throws IOException {
        String jsonStr = "";
        try {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            BufferedReader br = new BufferedReader(fileReader);

            String line;
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine())!=null) {
                sb.append(line);
            }

            fileReader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {

////        String path = readJson.class.getClassLoader().getResource("./json/temple_1.json").getPath();
//        String path = readJsonFile("/home/pisey/IdeaProjects/13Ajax/src/test/json/temple_1.json");
//        JSONObject jTemple_1 = JSON.parseObject(path);
//        System.out.println("job:"+jTemple_1);

//        String[] mission1 = {"asdr343-srqeef223-qerq84", "rtsp://192.168.1.110/live4", "rtmp://192.168.1.103/live/room84"};
//        String[] mission2 = {"asdr343-srqef223-qerq83", "rtsp://192.168.1.110/live3", "rtmp://192.168.1.103/live/room83"};
//        String[] mission3 = {"asdr343-srqeef223-qerq82", "rtsp://192.168.1.110/live2", "rtmp://192.168.1.103/live/room82"};
//
//        //Map 方式
//        Map<String, String[]> missions = new HashMap<String, String[]>();
//        missions.put("mission1", mission1);
//        missions.put("mission2", mission2);
//        missions.put("mission3", mission3);
//
//        Set<String> keySet = missions.keySet();
//        Iterator<String> it = keySet.iterator();
//        while(it.hasNext()) {
//            String key = it.next();
//            String[] value = missions.get(key);
//            System.out.println(key+"="+value);
//        }

        //二维数组
        String[][] allMission ={
//            {"asdr343-srqeef223-qerq00", "rtsp://192.168.1.100/live0", "rtmp://192.168.1.103/live/room00","rtmp://192.168.1.103/live/room20"},
            {"asdr343-srqeef223-qerq01", "rtsp://192.168.1.100/live1", "rtmp://192.168.1.103/live/room01","rtmp://192.168.1.103/live/room21"},
            {"asdr343-srqeef223-qerq02", "rtsp://192.168.1.100/live2", "rtmp://192.168.1.103/live/room02","rtmp://192.168.1.103/live/room22"},
            {"asdr343-srqeef223-qerq03", "rtsp://192.168.1.100/live3", "rtmp://192.168.1.103/live/room03","rtmp://192.168.1.103/live/room23"},
            {"asdr343-srqeef223-qerq04", "rtsp://192.168.1.100/live4", "rtmp://192.168.1.103/live/room04","rtmp://192.168.1.103/live/room24"},
            {"asdr343-srqeef223-qerq05", "rtsp://192.168.1.100/live5", "rtmp://192.168.1.103/live/room05","rtmp://192.168.1.103/live/room25"},

            {"asdr343-srqeef223-qerq10", "rtsp://192.168.1.101/live0", "rtmp://192.168.1.103/live/room10"},
            {"asdr343-srqeef223-qerq11", "rtsp://192.168.1.101/live1", "rtmp://192.168.1.103/live/room11"},
            {"asdr343-srqeef223-qerq12", "rtsp://192.168.1.101/live2", "rtmp://192.168.1.103/live/room12"},
            {"asdr343-srqeef223-qerq13", "rtsp://192.168.1.101/live3", "rtmp://192.168.1.103/live/room13"},
            {"asdr343-srqeef223-qerq14", "rtsp://192.168.1.101/live4", "rtmp://192.168.1.103/live/room14"},
            {"asdr343-srqeef223-qerq15", "rtsp://192.168.1.101/live5", "rtmp://192.168.1.103/live/room15"},

            {"asdr343-srqeef223-qerq60", "rtsp://192.168.1.106/live0", "rtmp://192.168.1.103/live/room60"},
            {"asdr343-srqeef223-qerq61", "rtsp://192.168.1.106/live1", "rtmp://192.168.1.103/live/room61"},
            {"asdr343-srqeef223-qerq62", "rtsp://192.168.1.106/live2", "rtmp://192.168.1.103/live/room62"},
            {"asdr343-srqeef223-qerq63", "rtsp://192.168.1.106/live3", "rtmp://192.168.1.103/live/room63"},
            {"asdr343-srqeef223-qerq64", "rtsp://192.168.1.106/live4", "rtmp://192.168.1.103/live/room64"},
            {"asdr343-srqeef223-qerq65", "rtsp://192.168.1.106/live5", "rtmp://192.168.1.103/live/room65"},

            {"asdr343-srqeef223-qerq80", "rtsp://192.168.1.110/live0", "rtmp://192.168.1.103/live/room80"},
            {"asdr343-srqeef223-qerq81", "rtsp://192.168.1.110/live1", "rtmp://192.168.1.103/live/room81"},
            {"asdr343-srqeef223-qerq82", "rtsp://192.168.1.110/live2", "rtmp://192.168.1.103/live/room82"},
            {"asdr343-srqeef223-qerq83", "rtsp://192.168.1.110/live3", "rtmp://192.168.1.103/live/room83"},
            {"asdr343-srqeef223-qerq84", "rtsp://192.168.1.110/live4", "rtmp://192.168.1.103/live/room84"},
            {"asdr343-srqeef223-qerq85", "rtsp://192.168.1.110/live5", "rtmp://192.168.1.103/live/room85"},
            };

        JSONObject jsonObj=null;
        Map<String,Object> misTem;
        for (int i = 0; i < allMission.length; i++) {
//            if (allMission[i].length==3){
            for (int j = 0; j < allMission[i].length; j++) {
//                System.out.println(allMission[i][j]);

                //创建Json模板
                misTem = new HashMap<>();
//                misTem.put("AITask_No","asdr343-srqeef223-qerq84");
                misTem.put("AITask_No",allMission[i][0]);
                misTem.put("AIBoard_No","1234123412332");

                misTem.put("IS_AIPushStream","1");
                misTem.put("IS_AIQuality","1");
                misTem.put("IS_Intelligent","0");

                Map<String, Object> sub_stream_Input = new HashMap<>();
                Scale input_Scale = new Scale("1920","1080","4096","50","25");
//                sub_stream_Input.put("Input_Source","rtsp://192.168.1.110/live4");
                sub_stream_Input.put("Input_Source",allMission[i][1]);
                sub_stream_Input.put("Input_Scale", input_Scale);
//                misTem.put("Input_Scale", sub_stream_Input);
                misTem.put("Stream_Input", sub_stream_Input);


                Map<String, Object> sub_stream_output = new HashMap<>();
                Scale output_Scale = new Scale("352","288","32","50","25");
//                sub_stream_output.put("Output_Source","rtmp://192.168.1.103/live84");
                sub_stream_output.put("Output_Source",allMission[i][2]);
                sub_stream_output.put("Output_Scale", output_Scale);
                misTem.put("Stream_Output_Low", sub_stream_output);

                QualityAnalysis quTask = new QualityAnalysis("update");
                misTem.put("QualityAnalysis_Task",quTask);

                IntelligentAnalysis inTask = new IntelligentAnalysis("00000000","5");
                misTem.put("IntelligentAnalysis_Task", inTask);

//                jsonObj = new JSONObject(misTem);

            if (allMission[i].length==4){
                Map<String, Object> sub_stream_output2 = new HashMap<>();
                Scale output_Scale2 = new Scale("720","576","1024","50","25");
//                sub_stream_output.put("Output_Source","rtmp://192.168.1.103/live84");
                sub_stream_output2.put("Output_Source",allMission[i][3]);
                sub_stream_output2.put("Output_Scale", output_Scale2);
                misTem.put("Stream_Output_High", sub_stream_output2);
                }
                jsonObj = new JSONObject(misTem);
            }
            System.out.println(jsonObj);
            try {
                sleep(1000*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("总共发送了"+allMission.length+"路视频流");

    }
}

