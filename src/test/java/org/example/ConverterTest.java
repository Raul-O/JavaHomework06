package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class ConverterTest
{
    /**
     * Rigorous Test :-)
     */
    @Test

    public void shouldReturnConvertedLength()
    {
        String stringTest = "100 cm + 10 m - 10 dm";
        String stringTest2 = "5 km - 100 mm + 10 m - 10 dm";
        assertEquals( "1000.0 cm", Converter.lengthConverter(stringTest));
        assertEquals( "5008900.0 mm", Converter.lengthConverter(stringTest2));
    }
}
