package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<User> findAllUsers();

    Collection<City> findAllCities();

    Collection<Candidate> findCandidatesLastDay();

    Collection<Post> findPostLastDay();

    void save(Post post);

    void save(Candidate candidate);

    void save(User user);

    void deleteCandidate(int id);

    Post findPostById(int id);

    Candidate findCandidateById(int id);

    User findUserByEmail(String email);

    City findCityByName(String name);
}
