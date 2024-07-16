package com.example.gpgpBack.added;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AddedServiceTest {

    @Mock private AddedRepository testAddedRep;
    private AddedService testAddedService;

    @BeforeEach
    void setUp(){
        testAddedService = new AddedService(testAddedRep);
    }

    @Test
    public void testGetAdditionsByType_Found() {
        // Given
        String type = "Type 1";
        List<String> types = List.of("Type 1", "Type 2");
        List<Added> additions = List.of(
            new Added(null, "Type 1", "Item 1", 10.0),
            new Added(null, "Type 1", "Item 2", 15.0)
        );

        when(testAddedRep.getAllTypes()).thenReturn(types);
        when(testAddedRep.getAdditionsByType(type)).thenReturn(additions);

        // When
        List<Added> result = testAddedService.getAdditionsByType(type);

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).extracting(Added::getAdded_Item).containsExactlyInAnyOrder("Item 1", "Item 2");

        verify(testAddedRep, times(1)).getAllTypes();
        verify(testAddedRep, times(1)).getAdditionsByType(type);
    }

    @Test
    public void testGetAdditionsByType_NotFound() {
        // Given
        String type = "Type 3";
        List<String> types = List.of("Type 1", "Type 2");

        when(testAddedRep.getAllTypes()).thenReturn(types);

        // When
        List<Added> result = testAddedService.getAdditionsByType(type);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAdd_Type()).isEqualTo("none");
        assertThat(result.get(0).getAdded_Item()).isEqualTo("none");
        assertThat(result.get(0).getAdded_Price()).isEqualTo(0.0);

        verify(testAddedRep, times(1)).getAllTypes();
        verify(testAddedRep, never()).getAdditionsByType(type);
    }

    @Test
    public void testGetAdditionsByType_Exception() {
        // Given
        String type = "Type 1";
        List<String> types = List.of("Type 1", "Type 2");

        when(testAddedRep.getAllTypes()).thenReturn(types);
        when(testAddedRep.getAdditionsByType(type)).thenThrow(new RuntimeException("Database error"));

        // When
        List<Added> result = testAddedService.getAdditionsByType(type);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getAdd_Type()).isEqualTo("none");
        assertThat(result.get(0).getAdded_Item()).isEqualTo("none");
        assertThat(result.get(0).getAdded_Price()).isEqualTo(0.0);

        verify(testAddedRep, times(1)).getAllTypes();
        verify(testAddedRep, times(1)).getAdditionsByType(type);
    }
}
