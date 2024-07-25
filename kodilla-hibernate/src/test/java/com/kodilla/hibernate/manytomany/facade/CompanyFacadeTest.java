package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTest {
    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @BeforeEach
    void cleanDatabaseBefore() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @AfterEach
    void cleanDatabaseAfter() {
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    void testFindCompaniesByNameFragment() {
        // Given
        Company company1 = new Company("ABC");
        Company company2 = new Company("BCD");
        Company company3 = new Company("ADS");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // When
        List<Company> companies = companyFacade.findCompaniesByNameFragment("A");

        // Then
        assertEquals(2, companies.size());

        // Clean up
        companyDao.deleteAll();
    }

    @Test
    void testFindEmployeesByLastnameFragment() {
        // Given
        Employee employee1 = new Employee("aaa", "abc");
        Employee employee2 = new Employee("bbb", "abd");
        Employee employee3 = new Employee("ccc", "xyz");

        employeeDao.save(employee1);
        employeeDao.save(employee2);
        employeeDao.save(employee3);

        // When
        List<Employee> employees = companyFacade.findEmployeesByLastnameFragment("ab");

        // Then
        assertEquals(2, employees.size());

        // Clean up
        employeeDao.deleteAll();
    }
}