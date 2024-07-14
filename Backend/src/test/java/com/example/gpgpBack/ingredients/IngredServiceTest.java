package com.example.gpgpBack.ingredients;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.gpgpBack.item.ItemRepository;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class IngredServiceTest {

    @Mock private IngredRepository testIngredRep;
    @Mock private ItemRepository testItemRep;
    private IngredService testIngredService;

    @BeforeEach
    void setUp(){
        testIngredService = new IngredService(testIngredRep, testItemRep);
    }
}
