package generic;

import java.util.List;

public class TypeErasureExample <T> {

    public void method(List<String> stringList)
    {
        stringList.add("1");
        stringList.add("foo");
    }
}
