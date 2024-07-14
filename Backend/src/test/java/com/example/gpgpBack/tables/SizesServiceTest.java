package com.example.gpgpBack.tables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class SizesServiceTest {

    @Mock private TablesRepository testTablesRep;
    private TablesService testTablesService;

    @BeforeEach
    void setUp(){
        testTablesService = new TablesService(testTablesRep);
    }
}
