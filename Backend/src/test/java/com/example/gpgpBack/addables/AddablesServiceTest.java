package com.example.gpgpBack.addables;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AddablesServiceTest {

    @Mock private AddablesRepository testAddRep;
    private AddablesService testAddService;

    @BeforeEach
    void setUp(){
        testAddService = new AddablesService(testAddRep);
    }

    @Test
    public void testGetAddablesByType_Found() {
        String itemType = "Type 1";
        Addables expectedAddable = new Addables( "none", false, false, false,
            false, false, false);

        List<String> types = Arrays.asList("Type 1", "Type 2");

        when(testAddRep.getAllTypes()).thenReturn(types);
        when(testAddRep.getAddablesByType(itemType)).thenReturn(expectedAddable);

        Addables actualAddable = testAddService.getAddablesByType(itemType);

        assertThat(actualAddable).isNotNull();
        assertThat(actualAddable.getSizable()).isFalse();
        assertThat(actualAddable.getMeats()).isFalse();
        assertThat(actualAddable.getCheeses()).isFalse();
        assertThat(actualAddable.getSauces()).isFalse();
        assertThat(actualAddable.getRemovables()).isFalse();
        assertThat(actualAddable.getExtras()).isFalse();
    }

    @Test
    public void testGetAddablesByType_NotFound() {
        String itemType = "Type 3";
        List<String> types = Arrays.asList("Type 1", "Type 2");

        when(testAddRep.getAllTypes()).thenReturn(types);

        Addables actualAddable = testAddService.getAddablesByType(itemType);

        assertThat(actualAddable).isNotNull();
        assertThat(actualAddable.getItem_Type()).isEqualTo("none");
        assertThat(actualAddable.getSizable()).isFalse();
        assertThat(actualAddable.getMeats()).isFalse();
        assertThat(actualAddable.getCheeses()).isFalse();
        assertThat(actualAddable.getSauces()).isFalse();
        assertThat(actualAddable.getRemovables()).isFalse();
        assertThat(actualAddable.getExtras()).isFalse();
    }

    @Test
    public void testGetAddablesByType_Exception() {
        String itemType = "Type 1";
        List<String> types = Arrays.asList("Type 1", "Type 2");

        when(testAddRep.getAllTypes()).thenReturn(types);
        when(testAddRep.getAddablesByType(itemType)).thenThrow(new RuntimeException("Database error"));

        Addables actualAddable = testAddService.getAddablesByType(itemType);

        assertThat(actualAddable).isNotNull();
        assertThat(actualAddable.getItem_Type()).isEqualTo("none");
        assertThat(actualAddable.getSizable()).isFalse();
        assertThat(actualAddable.getMeats()).isFalse();
        assertThat(actualAddable.getCheeses()).isFalse();
        assertThat(actualAddable.getSauces()).isFalse();
        assertThat(actualAddable.getRemovables()).isFalse();
        assertThat(actualAddable.getExtras()).isFalse();
    }
}
