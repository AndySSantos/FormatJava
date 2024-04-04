package org.example;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {
    Print p;
    @AfterAll
    static void inicial(){
        p = new Print();
    }

    @Test
    void std() {
        p.std("STD metodo");
    }

    @Test
    void stdl() {
        p.stdl("Metodo");
    }

    @Test
    void format() {
    }
}