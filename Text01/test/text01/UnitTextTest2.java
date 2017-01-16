package text01;

import org.junit.*;

/**
 * Created by 黄桂道 on 2017-1-7.
 */
public class UnitTextTest2 {
    @Before
    public void before() throws Exception {
        System.out.println("This is before...");
    }

    @After
    public void after() throws Exception {
        System.out.println("This is after...");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("This is beforeClass...");
    }

    @AfterClass
    public static void afterClasss() throws Exception {
        System.out.println("This is afterClass...");
    }

    @Test
    public void add() throws Exception {
        System.out.println("This is test...");

    }

    @Test
    public void add2() throws Exception {
        System.out.println("This is test2...");

    }

}