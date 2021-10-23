package ru.job4j.dream.servlet;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.Is;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
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

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(PsqlStore.class)
//public class PostServletTest {
//
//    @Test
//    public void whenCreatePost() throws ServletException, IOException {
//        final PostServlet servlet = new PostServlet();
//        final HttpServletRequest request = mock(HttpServletRequest.class);
//        final HttpServletResponse response = mock(HttpServletResponse.class);
//        String path = "/dream_job/posts.do";
//        Store store = MemStore.instOf();
//        PowerMockito.mockStatic(PsqlStore.class);
//        Mockito.when(PsqlStore.instOf()).thenReturn(store);
//        when(request.getParameter("id")).thenReturn("1");
//        when(request.getParameter("name")).thenReturn("Post1");
//        servlet.doPost(request, response);
//        Post rsl = store.findAllPosts().iterator().next();
//        assertThat(store.findPostById(1).getName(), is("Post1"));
//        Assert.assertThat(rsl.getName(), Is.is("Post1"));
//    }
//}