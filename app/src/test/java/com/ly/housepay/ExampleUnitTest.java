package com.ly.housepay;

import android.provider.Settings;
import android.util.Log;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        //assertEquals(4, 2 + 2);
        String a="-1.5";
        double ret=Double.parseDouble(a);
        System.out.println(ret);
    }
}