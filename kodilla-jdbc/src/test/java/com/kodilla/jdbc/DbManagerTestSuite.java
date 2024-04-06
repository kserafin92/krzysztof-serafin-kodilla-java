package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

class DbManagerTestSuite {

    @Test
    void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        assertNotNull(dbManager.getConnection());
    }
    @Test
    void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = ((Statement) statement).executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(5, counter);
    }
    @Test
    void testSelectUsersAndTasks() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT U.FIRSTNAME, U.LASTNAME, I.SUMMARY\n" +
                "  FROM USERS U\n" +
                "  JOIN ISSUES I ON U.ID = I.USER_ID_ASSIGNEDTO";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while (rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getString("SUMMARY"));
            counter++;
        }
        rs.close();
        statement.close();
        assertEquals(15, counter);
    }
    @Test
    public void testSelectUsersAndPosts() throws SQLException {

        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String query = "SELECT U.FirstName, U.LastName, COUNT(P.Id) AS PostCount " +
                "FROM Users U " +
                "JOIN Posts P ON u.ID = P.USER_ID " +
                "GROUP BY U.ID " +
                "HAVING PostCount >= 2;";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);

        //Then
        int counter = 0;
        while (rs.next()) {
            String firstName = rs.getString("FirstName");
            String lastName = rs.getString("LastName");
            int postCount = rs.getInt("PostCount");
            System.out.println(firstName + " " + lastName + " - " + postCount + " posts");
            counter++;
        }

        rs.close();
        statement.close();
        assertEquals(3, counter);


    }
}
