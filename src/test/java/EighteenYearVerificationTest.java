import org.junit.*;

public class EighteenYearVerificationTest {

    private EighteenYearVerification g_cEighteenYearVerification;

    @Before
    public void initTest() {
        g_cEighteenYearVerification = new EighteenYearVerification();
    }

    @After
    public void afterTest() {
        g_cEighteenYearVerification = null;
    }

    @Test
    public void testCheckingEighteenYear() {
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("1960-04-13"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("1990-02-28"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("1990-02-29"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("2002-04-15"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("2002-05-15"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("2020-11-16"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("9999-12-31"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("0001-01-01"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("1970-01-01"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("1980-13-21"));
    }

    @Test
    public void testEmpty() {
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear(""));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("  -  -    "));
    }

    @Test
    public void testIncorrectValue() {
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("2000-02-31"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("2000-02-314"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("1990-02-2l"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("190-02-21"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("1909-9-21"));
        Assert.assertEquals(true, g_cEighteenYearVerification.CheckingEighteenYear("199O-O2-21"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("19Я0.02.21"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("1900-021-21"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("21-03-1990"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("----------"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("0000-00-00"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("20010312"));
        Assert.assertEquals(false, g_cEighteenYearVerification.CheckingEighteenYear("2001&03;12"));
    }

}
