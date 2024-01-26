package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Forum {

    private  final List<ForumUser> users = new ArrayList<>();

    public Forum() {
        users.add(new ForumUser(1, "user1", 'M', LocalDate.of(1990, 1, 15), 10));
        users.add(new ForumUser(2, "user2", 'F', LocalDate.of(1995, 2, 10), 25));
        users.add(new ForumUser(3, "user3", 'M', LocalDate.of(1988, 3, 5), 35));
        users.add(new ForumUser(4, "user4", 'F', LocalDate.of(2000, 4, 20), 15));
        users.add(new ForumUser(5, "user5", 'M', LocalDate.of(1985, 5, 25), 50));
    }

    public List<ForumUser> getUserList() {
        return Collections.unmodifiableList(users);
    }
}

