package com.kodilla.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE READERS SET VIP_LEVEL=\"Not set\"";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
        String sqlCheckTable = "SELECT COUNT(*) AS HOW_MANY FROM READERS WHERE VIP_LEVEL=\"Not set\"";

        // When
        Statement statement2 = dbManager.getConnection().createStatement();
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement2.execute(sqlProcedureCall);
        ResultSet rs = statement.executeQuery(sqlCheckTable);

        // Then
        int howMany = -1;
        if (rs.next()) {
            howMany = rs.getInt("HOW_MANY");
        }
        assertEquals(0, howMany);
        rs.close();
        statement.close();
        statement2.close();

    }
    @Test
    public void testUpdateBestsellers() throws SQLException {
        // Given
        DbManager dbManager = DbManager.getInstance();


        Statement statement = dbManager.getConnection().createStatement();

        String sqlCleanupRents = "DELETE FROM RENTS";
        statement.executeUpdate(sqlCleanupRents);

        String sqlCleanupBooks = "UPDATE BOOKS SET BESTSELLER = FALSE";
        statement.executeUpdate(sqlCleanupBooks);

        String sqlInsertBooks = "INSERT INTO BOOKS (TITLE, PUBYEAR) VALUES " +
                "('Book 1', 2021), " +
                "('Book 2', 2020)";
        statement.executeUpdate(sqlInsertBooks);

        String sqlInsertRents = "INSERT INTO RENTS (BOOK_ID, READER_ID, RENT_DATE, RETURN_DATE) VALUES " +
                "(1, 1, NOW() - INTERVAL 1 MONTH, NULL), " +
                "(1, 2, NOW() - INTERVAL 15 DAY, NULL), " +
                "(2, 1, NOW() - INTERVAL 1 MONTH, NOW() - INTERVAL 10 DAY), " +
                "(2, 2, NOW() - INTERVAL 20 DAY, NOW() - INTERVAL 5 DAY), " +
                "(2, 3, NOW() - INTERVAL 10 DAY, NULL)";

        statement.executeUpdate(sqlInsertRents);


        String sqlInitialCheck = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet rsBefore = statement.executeQuery(sqlInitialCheck);
        int countBefore = -1;
        if (rsBefore.next()) {
            countBefore = rsBefore.getInt("HOW_MANY");
        }
        assertEquals(0, countBefore, "Initial state should have no bestsellers");

        // When
        String sqlProcedureCall = "CALL UpdateBestsellers()";
        statement.execute(sqlProcedureCall);

        // Then
        String sqlFinalCheck = "SELECT COUNT(*) AS HOW_MANY FROM BOOKS WHERE BESTSELLER = TRUE";
        ResultSet rsAfter = statement.executeQuery(sqlFinalCheck);
        int countAfter = -1;
        if (rsAfter.next()) {
            countAfter = rsAfter.getInt("HOW_MANY");
        }
        assertEquals(1, countAfter, "After running the procedure, there should be 1 bestseller");

        // Clean up
        rsBefore.close();
        rsAfter.close();
        statement.close();
    }
}

