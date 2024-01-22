package com.kodilla.testing.forum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ForumStatisticsTest {

    @Mock
    private com.kodilla.testing.forum.statistics.Statistics statisticsMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(30);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(2000);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(1000, forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getCommentsCount());

    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(50);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertTrue(forumStatistics.getCommentsCount() < forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsMoreThanPosts() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertTrue(forumStatistics.getCommentsCount() > forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        // Given
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(150);
        when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());

        // When
        forumStatistics.calculateAdvStatistics(statisticsMock);

        // Then
        assertEquals(0, forumStatistics.getUsersCount());

    }
}

