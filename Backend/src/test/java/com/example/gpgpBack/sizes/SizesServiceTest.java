package com.example.gpgpBack.sizes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SizesServiceTest {

    @Mock private SizesRepository testSizesRep;
    private SizesService testSizesService;

    @BeforeEach
    void setUp(){
        testSizesService = new SizesService(testSizesRep);
    }
}
