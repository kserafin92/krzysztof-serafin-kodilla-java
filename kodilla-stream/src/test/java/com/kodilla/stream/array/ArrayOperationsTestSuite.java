import com.kodilla.stream.array.ArrayOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage() {
        // Given
        int[] numbers = {1, 2, 3, 4, 5};

        // When
        double result = ArrayOperations.getAverage(numbers);

        // Then
        double expected = 3.0;
        assertEquals(expected, result, 0.001);
    }
}