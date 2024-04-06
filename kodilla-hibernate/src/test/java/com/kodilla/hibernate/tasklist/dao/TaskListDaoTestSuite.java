package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



@SpringBootTest

public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @BeforeEach
    public void clenup() {
        taskListDao.deleteAll();
    }
    @Transactional
    @Test
    void testFindByListName() {
        // Given
        TaskList taskList = new TaskList("ToDo", "To Do tasks");
        taskListDao.save(taskList);

        // When
        List<TaskList> foundLists = taskListDao.findByListName("ToDo");

        // Then
        assertNotNull(foundLists);
        assertEquals(1, (foundLists).size());


    }
}

