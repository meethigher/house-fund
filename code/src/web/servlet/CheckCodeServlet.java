package web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author https://github.com/meethigher
 */
@WebServlet("/checkcode")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();//绘图对象
        g.setColor(new Color(255, 255, 255, 255));
        g.fillRect(0, 0, width, height);
        //画边框
        g.setColor(new Color(255, 120, 127));
        g.drawRect(0, 0, width - 1, height - 1);
        //写验证码
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            //设置字体,绘制字符
            g.setColor(new Color(37, 173, 135));
            g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
            char c = str.charAt(r.nextInt(str.length()));
            stringBuilder.append(c);
            g.drawString(String.valueOf(c), width / 5 * (i + 1), height / 2 + 10);
        }
        //将验证码存入session
        String checkcode = stringBuilder.toString();
        request.getSession().setAttribute("checkcode", checkcode);
        //画干扰
        for (int i = 0; i < 10; i++) {
            int x1 = r.nextInt(width - 6) + 2;
            int y1 = r.nextInt(height - 6) + 2;
            int x2 = r.nextInt(width - 6) + 2;
            int y2 = r.nextInt(height - 6) + 2;
            //画点
            g.drawOval(x1, y1, 3, 3);
            g.fillOval(x1, y1, 3, 3);
            g.drawOval(x2, y2, 3, 3);
            g.fillOval(x2, y2, 3, 3);
        }
        ImageIO.write(image, "jpg", response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

