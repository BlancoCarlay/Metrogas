package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import utils.DriverFactory;

public class NoUsadaBaseTest {

    @BeforeEach
    public void setUp() {
        DriverFactory.getDriver();
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
