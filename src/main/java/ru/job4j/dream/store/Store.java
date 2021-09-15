package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private static final Store INST = new Store();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        LocalDateTime today = LocalDateTime.now();
        posts.put(1, new Post(1, "Junior Java Job", "Vacancies of developers beginner level", today));
        posts.put(2, new Post(2, "Middle Java Job", "Vacancies of developers middle level", today));
        posts.put(3, new Post(3, "Senior Java Job", "Vacancies of developers senior level", today));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}
