package com.ppbf.sandbox;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class SandboxTest {

    @org.junit.Test
    public void ex1() throws Exception {
        assertEquals(Sandbox.ex1(new ArrayList<>(), 1), null);
    }

    @org.junit.Test
    public void ex2() throws Exception {
        assertEquals(Sandbox.ex2(new ArrayList<>()), null);

    }

    @org.junit.Test
    public void ex3_1() throws Exception {
        assertEquals(Sandbox.ex3_1(new ArrayList<>(), new BigDecimal("1.1")), null);
    }

    @org.junit.Test
    public void ex3_2() throws Exception {
        assertEquals(Sandbox.ex3_2(new ArrayList<>(), new HashMap<>()), null);
    }

}
