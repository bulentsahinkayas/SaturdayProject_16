package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExercise {
    @DataProvider
    public Object[][] nameProvider(){
        return  new Object[][] {
                {"John", "Bolt",15},
                {"Mary","Watson", 20},
                {"Ahmad", "Kaya", 34}

        };
    }
    @Test(dataProvider = "nameProvider")
    public void testName(String name, String lastName, Integer age) {
        System.out.println("My name is " + name + " " + lastName);
        System.out.println("I am " + age + " years old.");
    }

}
