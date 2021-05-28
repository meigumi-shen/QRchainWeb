package org.com.QRservlet;

import lombok.SneakyThrows;
import org.com.fisco.QR;
import org.com.sol;
import org.com.util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class logoutQRCoinServlet extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String QRHash = req.getParameter("QRHash");
        QR qrsol = sol.initSol(QRHash);
        String logouthash = req.getParameter("logoutQRHash");
        byte[] hash = util.hexString2bytes(logouthash);
        String res = sol.logoutQRCoin(qrsol,hash);
//        设置回调
        Writer writer = resp.getWriter();
        writer.write(res);
    }
}
