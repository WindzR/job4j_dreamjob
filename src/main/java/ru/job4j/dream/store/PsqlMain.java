package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

public class PsqlMain {
    public static void main(String[] args) {
        Store store = PsqlStore.instOf();
        store.save(new Post(0, "Java Job"));
        store.save(new Post(1, "Python Job"));
        store.save(new Post(2, "Golang Job"));
        System.out.println("<----Список вакансий в базе данных Postgres ---->");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        System.out.println("<----Найдем вакансию по ID = 1 ---->");
        System.out.println(store.findById(1));
        System.out.println("<----Изменим вакансию по ID = 1 ---->");
        store.save(new Post(1, "Super Galactic Power Java Junior"));
        System.out.println(store.findById(1));
    }
}
