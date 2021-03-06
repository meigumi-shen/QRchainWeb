package org.com.QRservlet;
import lombok.SneakyThrows;
import org.com.sol;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

public class addAdministratorServlet extends HttpServlet{
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String QRHash = req.getParameter("QRHash");
        String res = sol.addAdministrator(sol.initSol(QRHash));

//        设置回传
        Writer writer = resp.getWriter();
        writer.write(res);
    }
}
