package com.example.gpgpBack.tables;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class TablesRepositoryTest {

    @Autowired
    private TablesRepository testTablesRep;

    @AfterEach
    void tearDown(){
        testTablesRep.deleteAll();
    }

    @Test
    void testGetAvailableTables() {
        Tables table1 = new Tables(1L, false, false, false, "Cash");
        testTablesRep.save(table1);

        Tables table2 = new Tables(2L, false, false, false, "Cash");
        testTablesRep.save(table2);

        Tables table3 = new Tables(3L, false, false, false, "Cash");
        testTablesRep.save(table3);

        List<Long> availableTables = testTablesRep.getAvailableTables(false);

        assertThat(availableTables).isNotNull();
        assertThat(availableTables).isNotEmpty();
    }

    @Test
    void testGetAllTables() {

        Tables table1 = new Tables(1L, false, false, false, "Cash");
        testTablesRep.save(table1);

        Tables table2 = new Tables(2L, false, false, false, "Cash");
        testTablesRep.save(table2);

        Tables table3 = new Tables(3L, false, false, false, "Cash");
        testTablesRep.save(table3);

        List<Tables> allTables = testTablesRep.getAllTables();

        assertThat(allTables).isNotNull();
        assertThat(allTables).isNotEmpty();
    }

    @Test
    @Disabled
    void testIsWaiterCalled() {

        Tables table1 = new Tables(1L, false, false, false, "Cash");
        testTablesRep.save(table1);

        boolean isCalled = testTablesRep.isWaiterCalled(1L);

        assertThat(isCalled).isFalse(); // Assuming default value is false
    }

    @Test
    @Disabled
    void testIsTableFinished() {

        Tables table1 = new Tables(1L, false, false, false, "Cash");
        testTablesRep.save(table1);

        boolean isFinished = testTablesRep.isTableFinished(1L);

        assertThat(isFinished).isFalse(); // Assuming default value is false
    }
}

