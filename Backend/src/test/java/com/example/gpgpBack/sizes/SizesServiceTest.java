package com.example.gpgpBack.sizes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SizesServiceTest {

    @Mock private SizesRepository testSizesRep;
    private SizesService testSizesService;

    @BeforeEach
    void setUp(){
        testSizesService = new SizesService(testSizesRep);
    }

    @Test
    void testFindSizes_WhenTypeExists() {
        String itemType = "Pizza";
        Sizes size1 = new Sizes(1L, itemType, "Small", 5.0);
        Sizes size2 = new Sizes(2L, itemType, "Large", 10.0);

        when(testSizesRep.checkSize(itemType)).thenReturn(itemType);
        when(testSizesRep.findSizes(itemType)).thenReturn(List.of(size1, size2));

        List<Sizes> sizes = testSizesService.findSizes(itemType);

        assertNotNull(sizes);
        assertEquals(2, sizes.size());
        assertEquals("Small", sizes.get(0).getItem_Size());
        assertEquals("Large", sizes.get(1).getItem_Size());

        verify(testSizesRep, times(1)).checkSize(itemType);
        verify(testSizesRep, times(1)).findSizes(itemType);
    }

    @Test
    void testFindSizes_WhenTypeDoesNotExist() {
        String itemType = "NonExistentType";

        when(testSizesRep.checkSize(itemType)).thenReturn(null);

        List<Sizes> sizes = testSizesService.findSizes(itemType);

        assertNotNull(sizes);
        assertEquals(1, sizes.size());
        assertEquals("Not Found", sizes.get(0).getItem_Size());

        verify(testSizesRep, times(1)).checkSize(itemType);
        verify(testSizesRep, times(0)).findSizes(itemType);
    }

    @Test
    void testFindSizes_WhenExceptionOccurs() {
        String itemType = "Pizza";

        when(testSizesRep.checkSize(anyString())).thenThrow(new RuntimeException("Database error"));

        List<Sizes> sizes = testSizesService.findSizes(itemType);

        assertNotNull(sizes);
        assertEquals(1, sizes.size());
        assertEquals("Not Found", sizes.get(0).getItem_Size());

        verify(testSizesRep, times(1)).checkSize(itemType);
        verify(testSizesRep, times(0)).findSizes(itemType);
    }
}
