import java.io.IOException;
import java.util.logging.*;

public class Person
{
    private String name;
    private String surname;
    private int age;

    public static final Logger logger;

    static
    {
        logger = Logger.getLogger(Person.class.getName());
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false);

        Handler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        Formatter formatter = new Formatter()
        {
            @Override
            public String format(LogRecord record)
            {
                return record.getLevel() + " " + record.getMessage() + '\n';
            }
        };
        //handler.setFormatter(formatter);
        logger.addHandler(handler);

        FileHandler fileHandler = null;
        try
        {
            fileHandler = new FileHandler("wyniki.txt");
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        Filter filter = new Filter()
        {
            @Override
            public boolean isLoggable(LogRecord record)
            {
                return !record.getMessage().startsWith("initials");
            }
        };
        fileHandler.setFilter(filter);
        fileHandler.setFormatter(formatter);
        logger.addHandler(fileHandler);
    }

    public Person(String name, String surname, int age)
    {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }

    public void introduce()
    {
        logger.log(Level.SEVERE, "introduce logging");
        System.out.println("My name is " + name + " " + surname + " and I am " + age);
    }

    public void showInitials()
    {
        logger.log(Level.FINE, "initials logging");
        logger.throwing(Main.class.getName(), "main", new IOException());
        System.out.println(getName().substring(0, 1) + getSurname().substring(0, 1));
    }
}