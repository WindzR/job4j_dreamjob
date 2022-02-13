package ru.job4j.dream.servlet;

import ru.job4j.dream.model.City;
import ru.job4j.dream.model.User;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

public class RegServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Store store = PsqlStore.instOf();
        Collection<City> cities = store.findAllCities();
        System.out.println("Cities LIST --- " + cities);
        req.setAttribute("cities", cities);
        req.getRequestDispatcher("reg.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Store store = PsqlStore.instOf();
        Collection<City> cities = store.findAllCities();
        req.setAttribute("cities", cities);
        if (store.findUserByEmail(email) != null) {
            req.setAttribute("message", "Пользователь с таким email уже зарегистрирован");
            req.getRequestDispatcher("reg.jsp").forward(req, resp);
        } else {
            store.save(new User(0, name, email, password));
            resp.sendRedirect(req.getContextPath() + "/auth.do");
        }
    }
}
