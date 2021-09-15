package ru.job4j.dream.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post {
    private int ID;
    private String name;
    private String description;
    private LocalDateTime created;

    public Post(int ID, String name, String description, LocalDateTime created) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.created = created;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return ID == post.ID && name.equals(post.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }
}
