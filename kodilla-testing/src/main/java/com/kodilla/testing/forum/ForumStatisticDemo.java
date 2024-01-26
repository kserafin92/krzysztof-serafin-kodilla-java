package com.kodilla.testing.forum;

import java.util.Arrays;
import java.util.List;

public class ForumStatisticDemo implements Statistic {
    private List<String> usersNames;
    private int postsCount;
    private int commentsCount;

    public void ForumStatisticsDemo(List<String> usersNames, int postsCount, int commentsCount) {
        this.usersNames = usersNames;
        this.postsCount = postsCount;
        this.commentsCount = commentsCount;
    }

    @Override
    public List<String> usersNames() {
        return usersNames;
    }

    @Override
    public int postsCount() {
        return postsCount;
    }

    @Override
    public int commentsCount() {
        return commentsCount;
    }

    public static void main(String[] args) {
        List<String> users = Arrays.asList("User1", "User2", "User3");
        int posts = 20;
        int comments = 50;

        ForumStatistics forumStatistics = new ForumStatistics();
        forumStatistics.calculateAdvStatistics((Statistic) forumStatistics);
        forumStatistics.showStatistics();
    }
}