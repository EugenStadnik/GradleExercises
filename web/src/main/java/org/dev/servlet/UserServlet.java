package org.dev.servlet;

import com.dev.service.UserService;
import com.dev.util.StringUtils;
import io.restassured.http.ContentType;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType(ContentType.HTML.name());
        PrintWriter writer = resp.getWriter();
        userService.getAll().forEach(user -> writer.write("<h1>%d: %s</h1>".formatted(user.id(), StringUtils.trim(user.name()))));
    }
}
