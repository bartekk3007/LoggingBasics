import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{
    public static void main(String[] args)
    {
        Logger.global.setLevel(Level.ALL);
        Logger.global.info("First logging");
        Logger.global.throwing(Main.class.getName(), "main", new IOException());
        System.out.println();

        Person p1 = new Person("Bartek", "Kołakowski", 30);
        p1.introduce();
        p1.showInitials();

        System.out.println(System.getProperty("user.home"));

        while(true)
        {

        }
    }
}