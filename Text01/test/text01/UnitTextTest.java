package text01;

import org.junit.*;

/** 
* UnitText Tester. 
* 
* @author <Authors name> 
* @since <pre>01/07/2017</pre> 
* @version 1.0 
*/ 
public class UnitTextTest { 

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


/** 
* 
* Method: getDate() 
* 
*/ 
@Test
public void testGetDate() throws Exception { 
//TODO: Test goes here...
    UnitText test = new UnitText();
    String s = test.getDate();
    Assert.assertEquals("hello word",s);
} 

/** 
* 
* Method: add(int a, int b) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(4,new UnitText().add(1,3));
} 

/** 
* 
* Method: subtract(int a, int b) 
* 
*/ 
@Test
public void testSubtract() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(17,new UnitText().subtract(20,3));
} 

/** 
* 
* Method: multiply(int a, int b) 
* 
*/ 
@Test
public void testMultiply() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(7,new UnitText().multiply(2,3));
} 

/** 
* 
* Method: divide(int a, int b) 
* 
*/ 
@Test
public void testDivide() throws Exception { 
//TODO: Test goes here...
    Assert.assertEquals(7,new UnitText().divide(21,0));
} 


} 
