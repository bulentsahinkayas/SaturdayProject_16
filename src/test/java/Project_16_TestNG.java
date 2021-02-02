import org.testng.Assert;
import org.testng.annotations.Test;

public class Project_16_TestNG {
    String word;
    String word1 = "AB";
    String word2 = "A".concat("B");
    @Test
    public void test1(){
        Assert.assertFalse(false);
    }
    @Test
    public void test2(){
        Assert.assertNull(word);
    }
    @Test
    public void test3(){
        Assert.assertSame(word1,word2);
    }
    @Test
    public void test4(){
        Assert.assertEquals(word1,word2);
    }
}
