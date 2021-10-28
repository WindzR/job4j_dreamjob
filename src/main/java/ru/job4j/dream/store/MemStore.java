package ru.job4j.dream.store;

import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.User;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();

    private static AtomicInteger POST_ID = new AtomicInteger(4);

    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private static AtomicInteger USER_ID = new AtomicInteger(4);

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private MemStore() {
        LocalDateTime today = LocalDateTime.now();
        posts.put(1, new Post(1, "Junior Java Job", "Vacancies of developers beginner level", today));
        posts.put(2, new Post(2, "Middle Java Job", "Vacancies of developers middle level", today));
        posts.put(3, new Post(3, "Senior Java Job", "Vacancies of developers senior level", today));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public static MemStore instOf() {
        return INST;
    }

    @Override
    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void save(User user) {
        if (user.getId() == 0) {
            user.setId(USER_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    public void deleteCandidate(int id) {
        candidates.remove(id);
    }

    @Override
    public Post findPostById(int id) {
        return posts.get(id);
    }

    @Override
    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> user = users.values()
                .stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst();
        return user.orElseGet(
                () -> new User(0, "default", "default", "0000")
        );
    }

    @Override
    public City findCityByName(String name) {
        return null;
    }

    @Override
    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    @Override
    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    @Override
    public Collection<User> findAllUsers() {
        return users.values();
    }

    @Override
    public Collection<City> findAllCities() {
        return null;
    }

    @Override
    public Collection<Candidate> findCandidatesLastDay() {
        return null;
    }

    @Override
    public Collection<Post> findPostLastDay() {
        return null;
    }
}
