package annotation;

import org.testng.Assert;

public class WebbTests {

    @WebbBeforeClass
    public void setUp() {
        System.out.println("setup called ......");
    }

    @WebbBeforeMethod
    public void methodConfig() {
        System.out.println("before method ...");
    }

    @WebbTest(online = false,
            error = "invalid path",
            desc = "scroll to position and upload file",
            os = OS.MOZILA)
    public void test1() {
        Assert.assertEquals(5, 15);
    }

    @WebbTest(error = "invalid path",
            desc = "scroll to position and download file")
    public void test2() {
        Assert.assertEquals(5, 5);
    }

    @WebbTest(error = "invalid path",
            desc = "scroll to position and upload file",
            os = OS.MOZILA)
    public void test3() {
        Assert.assertEquals(5, 6);
    }

    @WebbTest()
    public void test4() {
        Assert.assertEquals(5, 5);
    }

    @WebbAfterMethod
    public void afterMethod() {
        System.out.println("after method ...");
    }

    @WebbAfterClass
    public void tearDown() {
        System.out.println("tear down......");
    }
}