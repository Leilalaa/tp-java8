package java8.ex06;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Exercice 06 - Period
 */
public class DateAndTime_06_Test {

    @Test
    public void test_period() throws Exception {

        
        LocalDate localDate1 =  LocalDate.of(2017, 12, 31);

       
        LocalDate localDate2 =  LocalDate.of(2050, 01, 01);

        
        Period result = Period.between(localDate1, localDate2);

        assertThat(result.toTotalMonths(), is(384L));
    }
}
