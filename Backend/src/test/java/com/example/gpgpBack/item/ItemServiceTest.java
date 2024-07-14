package com.example.gpgpBack.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock private ItemRepository testItemRep;
    private ItemService testItemService;

    @BeforeEach
    void setUp(){
        testItemService = new ItemService(testItemRep);
    }

    @Test
    void testGetAdditionsByType() {

    }
}
