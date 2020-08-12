package web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import server.Feedback;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/service/video.SetAIBoardTask")
public class AjaxPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
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
            System.out.println("接收json数据异常");
        }
        finally {
            reader.close();
        }

        //对字符串进行序列化
        JSONObject jsonObject = JSON.parseObject(jsonString.toString());
        System.out.println(jsonObject);

//        //1.获取请求参数
//        String username = request.getParameter("username");

       /* //处理业务逻辑。耗时
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        //2.打印username
//        System.out.println(username);

        //3.响应
//        response.getWriter().write("hello : " + username);

        Feedback fmsg = new Feedback("200", "指令处理成功");
        JSONObject jsonObj = (JSONObject) JSON.toJSON(fmsg);

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObj.toString());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
