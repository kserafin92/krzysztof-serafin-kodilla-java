package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        // Given
        User millenialsUser = new Millenials("MillenialsUser");
        User yGenerationUser = new YGeneration("YGenerationUser");
        User zGenerationUser = new ZGeneration("ZGenerationUser");

        // When
        String millenialsShare = millenialsUser.sharePost();
        String yGenerationShare = yGenerationUser.sharePost();
        String zGenerationShare = zGenerationUser.sharePost();

        // Then
        assertEquals("Facebook", millenialsShare);
        assertEquals("Twitter", yGenerationShare);
        assertEquals("Snapchat", zGenerationShare);
    }

    @Test
    public void testIndividualSharingStrategy() {
        // Given
        User user = new User("TestUser");

        // When
        String initialShare = user.sharePost();
        user.setSocialPublisher(new TwitterPublisher());
        String newShare = user.sharePost();

        // Then
        assertEquals("Facebook", initialShare);
        assertEquals("Twitter", newShare);
    }
}
