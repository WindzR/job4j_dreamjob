package ru.job4j.dream.servlet;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.MemStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class CandidateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("candidates", MemStore.instOf().findAllCandidates());
        req.getRequestDispatcher("candidates.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            doDelete(req, resp);
        } else {
            MemStore.instOf().save(
                    new Candidate(
                            Integer.parseInt(req.getParameter("id")),
                            req.getParameter("name")
                    ));
        }
        resp.sendRedirect(req.getContextPath() + "/candidates.do");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemStore store = MemStore.instOf();
        int id = Integer.parseInt(req.getParameter("id"));
        store.deleteCandidate(id);
        File folder = new File("c:\\images\\");
        deleteImage(req.getParameter("id"), folder);
        doGet(req, resp);
    }

    private void deleteImage(String id, File folder) {
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            String fileName = file.getName().split("\\.")[0];
            if (id.equals(fileName)) {
                file.delete();
                break;
            }
        }
    }
}
