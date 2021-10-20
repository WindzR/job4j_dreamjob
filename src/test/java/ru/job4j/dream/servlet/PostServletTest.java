package ru.job4j.dream.servlet;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Ignore
@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class PostServletTest {

    @Test
    public void whenCreatePost() throws ServletException, IOException {
        Store store = MemStore.instOf();
        PowerMockito.mockStatic(PsqlStore.class);
        PowerMockito.when(PsqlStore.instOf()).thenReturn(store);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PowerMockito.when(req.getParameter("id")).thenReturn("0");
        PowerMockito.when(req.getParameter("name")).thenReturn("User1");
        new PostServlet().doPost(req, resp);
        Post rsl = store.findAllPosts().iterator().next();
        Assert.assertThat(rsl.getName(), Is.is("User1"));
    }
}