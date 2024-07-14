package com.example.gpgpBack.added;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AddedServiceTest {

    @Mock private AddedRepository testAddedRep;
    private AddedService testAddedService;

    @BeforeEach
    void setUp(){
        testAddedService = new AddedService(testAddedRep);
    }

    @Test
    void testGetAdditionsByType() {

    }
}
