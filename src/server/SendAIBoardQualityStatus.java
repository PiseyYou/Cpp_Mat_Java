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

@WebServlet("/service/video.SendAIBoardQualityStatus")
public class SendAIBoardQualityStatus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String remoteAddr = request.getRemoteAddr();
//        System.out.println("remoteAdd:"+ remoteAddr);

        String Addr = request.getRemoteAddr();
        String sendURI = request.getRequestURI();
        System.out.println("URL:" + Addr + sendURI);

//        StringBuffer sendURL = request.getRequestURL();
//        System.out.println("URL:" + sendURL.toString());

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

        Feedback fmsg = new Feedback("200", "指令处理成功");
        JSONObject jsonObj = (JSONObject) JSON.toJSON(fmsg);
//        JSONObject jsonObj = JSON.parseObject(fmsg);
//
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObj.toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
