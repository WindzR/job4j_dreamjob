package ru.job4j.dream.servlet;

import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Store store = PsqlStore.instOf();
        if (store.findUserByEmail(email) != null) {
            req.setAttribute("message", "Пользователь с таким email уже зарегистрирован");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
        if (name.equals("") || email.equals("") || password.equals("")) {
            req.setAttribute("error", "Заполните все поля!");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        }
        store.save(new User(0, name, email, password));
        resp.sendRedirect(req.getContextPath() + "/auth.do");
    }
}
