package servlet;

import bean.UserInfo;
import bean.Watermark;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Hello World程序
 *
 * @author fangzhiyang
 */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String studentId = req.getParameter("studentId");
        System.out.println(studentId);

        String comment = req.getParameter("comment");
        System.out.println(comment);

        // TODO: 将学生返回的信息保存

        resp.getWriter().print("success");

        // 拼装json代码
//        UserInfo userInfo = new UserInfo();
//        userInfo.setOpenId("OPENID");
//        userInfo.setNickName("nickname");
//
//        Watermark watermark = new Watermark();
//        watermark.setAppid("APPID");
//        watermark.setTimestamp("TIMESTAMP");
//
//        userInfo.setWatermark(watermark);
//
//        JSONObject jsonObject = new JSONObject(userInfo);
//
//        resp.getWriter().print(jsonObject);

    }
}
