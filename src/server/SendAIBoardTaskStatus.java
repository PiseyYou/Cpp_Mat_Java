package server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

@WebServlet("/service/video.SendAIBoardTaskStatus")
public class SendAIBoardTaskStatus extends HttpServlet {
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
        } finally {
            reader.close();
        }

        JSONObject jsonObject = JSON.parseObject(jsonString.toString());
        System.out.println(jsonObject);

//        System.out.println(jsonObject.get("time"));

//        Map<String, Object> map =jsonObject;
//        for (Map.Entry<String, Object> entry : map.entrySet()) {
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }

        Feedback fmsg = new Feedback("200", "指令处理成功");
//        JSONObject jsonObj = (JSONObject) JSON.toJSON(fmsg);
//        JSONObject jsonObj = JSONObject.toJSON(fmsg);
        JSONObject jsonObj = JSON.parseObject(fmsg.toString());
//
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(jsonObj.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
