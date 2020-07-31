package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import domain.TaskStatus;
import org.junit.Test;
import server.Feedback;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FastsonTest {
    @Test
    public void test1() {
        String msg1 = "{\"code\":\"200\",\"msg\":\"指令处理成功\"}";
//        String json = "{"code":"200","msg":"指令处理成功"}";
        JSONObject jsonObject = JSON.parseObject(msg1);
        System.out.println(jsonObject);
//        System.out.println(jsonObject.getString("code")+":"+jsonObject.getString("msg"));
    }

    @Test
    public void test2() {
        Map<String, Object> msg2 = new HashMap<>();
        msg2.put("code", "200");
        msg2.put("msg", "指令处理成功");

        JSONObject jsonObj = new JSONObject(msg2);
        jsonObj.put("comment", "attention");
        System.out.println(jsonObj);
        System.out.println(jsonObj.get("code"));
    }

    @Test
    public void testJsonArray() {
        List<Object> list = new ArrayList<>();
        list.add(new TaskStatus("asdfadsfasd", "1", "-1", "1", "质量模块故障，原因．．．"));
        list.add(new TaskStatus("abcdefg", "1", "1", "-1", "质量模块故障，原因．．．"));

        JSONArray jsonArr = JSONArray.parseArray(JSON.toJSONString(list));
        System.out.println(jsonArr);
    }

    @Test
    public void testObject() {
        Feedback msg = new Feedback("200","指令处理成功");
        JSONObject jsonObj = (JSONObject) JSON.toJSON(msg);
//        JSONObject jsonObj = JSON.toJSON(msg);
        System.out.println(jsonObj);

//        String s = JSON.toJSONString(msg);
//        System.out.println(s);
    }

}
