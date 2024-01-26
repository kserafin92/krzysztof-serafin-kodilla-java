package com.kodilla.testing.forum;

import java.util.List;

interface Statistic {
    List<String> usersNames(); // list of users names

    int postsCount();          // total quantity of forum posts

    int commentsCount();       // total quantity of forum comments
}
