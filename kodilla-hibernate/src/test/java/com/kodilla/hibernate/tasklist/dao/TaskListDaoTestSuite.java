package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest

public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("ToDo", "To Do tasks");
        taskListDao.save(taskList);

        // When
        List<TaskList> foundLists = taskListDao.findByListName("ToDo");

        // Then
        assertNotNull(foundLists);
        assertEquals(1, ((List<?>) foundLists).size());

        //CleanUp
        taskListDao.deleteById(id);
    }
}

