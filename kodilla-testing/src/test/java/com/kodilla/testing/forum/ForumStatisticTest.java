package com.kodilla.testing.forum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ForumStatisticTest {

    @Mock
    private Statistic statisticMock;

    private ForumStatistics forumStatistics;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        forumStatistics = new ForumStatistics();
    }

    @Test
    void testCalculateAdvStatisticsWithZeroPosts() {
        // Given
        when(statisticMock.postsCount()).thenReturn(0);
        when(statisticMock.commentsCount()).thenReturn(30);
        when(statisticMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertEquals(0, forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithThousandPosts() {
        // Given
        when(statisticMock.postsCount()).thenReturn(1000);
        when(statisticMock.commentsCount()).thenReturn(2000);
        when(statisticMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertEquals(1000, forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithZeroComments() {
        // Given
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(0);
        when(statisticMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertEquals(0, forumStatistics.getCommentsCount());

    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsLessThanPosts() {
        // Given
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(50);
        when(statisticMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertTrue(forumStatistics.getCommentsCount() < forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWhenCommentsMoreThanPosts() {
        // Given
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(150);
        when(statisticMock.usersNames()).thenReturn(Collections.singletonList("User"));

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertTrue(forumStatistics.getCommentsCount() > forumStatistics.getPostsCount());

    }

    @Test
    void testCalculateAdvStatisticsWithZeroUsers() {
        // Given
        when(statisticMock.postsCount()).thenReturn(100);
        when(statisticMock.commentsCount()).thenReturn(150);
        when(statisticMock.usersNames()).thenReturn(Collections.emptyList());

        // When
        forumStatistics.calculateAdvStatistics(statisticMock);

        // Then
        assertEquals(0, forumStatistics.getUsersCount());

    }
}
