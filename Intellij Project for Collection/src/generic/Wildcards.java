package generic;

import java.util.List;

public class Wildcards {

    public static void printCollection(List<?> objects)
    {
        for (Object t : objects)
        {
            System.out.println(t);
        }
    }

}
