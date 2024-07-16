package com.example.gpgpBack.tables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TablesServiceTest {

    @Mock private TablesRepository testTablesRep;
    private TablesService testTablesService;

    @BeforeEach
    void setUp(){
        testTablesService = new TablesService(testTablesRep);
    }

     @Test
    void testGetAllItems() {
        List<Tables> tables = List.of(new Tables(), new Tables());
        when(testTablesRep.getAllTables()).thenReturn(tables);

        List<Tables> theTables = testTablesService.getAllItems();

        assertThat(theTables).hasSize(2);
        verify(testTablesRep, times(1)).getAllTables();
    }

    @Test
    void testGetAvailableTables() {
        List<Long> tableNumbers = List.of(1L, 2L);
        when(testTablesRep.getAvailableTables(false)).thenReturn(tableNumbers);

        List<Long> availableTables = testTablesService.getAvailableTables(false);

        assertThat(availableTables).hasSize(2);
        verify(testTablesRep, times(1)).getAvailableTables(false);
    }

    @Test
    void testSit() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));

        testTablesService.sit(1L);

        assertThat(table.isOccupied()).isTrue();
        verify(testTablesRep, times(1)).findById(1L);
    }

    @Test
    void testUnsit() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));

        testTablesService.unsit(1L);

        assertThat(table.isOccupied()).isFalse();
        verify(testTablesRep, times(1)).findById(1L);
    }

    @Test
    void testCallWaiter() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));


        testTablesService.callWaiter(1L);

        assertThat(table.isWaiter_Called()).isTrue();
        verify(testTablesRep, times(1)).findById(1L);
    }

    @Test
    void testHaveFinished() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));


        testTablesService.haveFinished(1L);

        assertThat(table.isFinished()).isTrue();
        verify(testTablesRep, times(1)).findById(1L);
        verify(testTablesRep, times(1)).isTableFinished(1L);
    }

    @Test
    void testChangePaymentMethod() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));

        testTablesService.changePaymentMethod(1L, "Card");

        assertThat(table.getPayment()).isEqualTo("Card");
        verify(testTablesRep, times(1)).findById(1L);
    }

    @Test
    void testPeopleLeftTable() {
        Tables table = new Tables(1L, false, false, false, "Cash");
        when(testTablesRep.findById(anyLong())).thenReturn(Optional.of(table));

        testTablesService.peopleLeftTable(1L);

        assertThat(table.isOccupied()).isFalse();
        assertThat(table.isWaiter_Called()).isFalse();
        assertThat(table.isFinished()).isFalse();
        assertThat(table.getPayment()).isEqualTo("Cash");
        verify(testTablesRep, times(1)).findById(1L);
    }
}
