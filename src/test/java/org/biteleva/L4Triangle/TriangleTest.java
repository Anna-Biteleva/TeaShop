package org.biteleva.L4Triangle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {

    static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    Triangle triangle = new Triangle();

    static int i = 0;
    static int j = 0;
    static int k = 0;

    @ParameterizedTest
    @CsvSource({ "5,8,6,10.39 ","10,8,12,39.69"})

    void positiveTest (int a, int b, int c, double abrResult) throws NegativeLengthException, IncompatibleLengthException {

        Assertions.assertEquals(abrResult, triangle.triangleSquare(a, b, c));
        i++;
        logger.info("Позитивный тест N"+i + " прошел" );

    }

    @ParameterizedTest

    @CsvSource({ "5,-8,6 ","-10,-8,12","-10,-8,-12" })

    void negativeLengthTest (int a, int b, int c)
    {
        Assertions.assertThrows(NegativeLengthException.class, () -> triangle.triangleSquare(a, b, c));
        j++;
        logger.info("Тест N"+j + " на NegativeLengthException прошел" );

    }

    @ParameterizedTest

    @CsvSource({ "5,8,60 ","10,8,120","10,80,12" })

    void incompatibleLengthTest (int a, int b, int c)
    {
         Assertions.assertThrows(IncompatibleLengthException.class, () -> triangle.triangleSquare(a, b, c));
        k++;
        logger.info("Тест N"+ k + " на IncompatibleLengthException прошел" );

    }
}










