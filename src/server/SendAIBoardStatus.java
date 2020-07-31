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
import java.util.HashMap;
import java.util.Map;

@WebServlet("/service/video.SendAIBoardStatus")
public class SendAIBoardStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        System.out.println(jsonString);


//        jsonObj.put("comment", "attention");
//        System.out.println(jsonObj);

        Feedback fmsg = new Feedback("200", "指令处理成功");
        JSONObject jsonObj = (JSONObject) JSON.toJSON(fmsg);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObj.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
