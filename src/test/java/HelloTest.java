import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloTest {
    // f(name)  = "Hello Oat!"
    @Test
    @DisplayName("test method welcome")
    public void welcome(){
        Hello hello = new Hello();
        String name = "Oat";
        // Act
        String actualResult = hello.welcome(name);
        // Assert
        assertEquals("Hello Oat!",actualResult);
    }
}