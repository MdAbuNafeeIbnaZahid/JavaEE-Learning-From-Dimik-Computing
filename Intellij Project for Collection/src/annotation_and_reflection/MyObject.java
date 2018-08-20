package annotation_and_reflection;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@MyAnnotation(value = "123", name = "Jackob", age=37, newNames = {"Jenkov", "Peterson"})
public class MyObject implements Interface1, Interface2 {
    public int i;
    public int j;
    private String privateString = "privateString";
    int packPublic;

    public MyObject(){}

    @Override
    public String toString() {
        return "MyObject{" +
                "i=" + i +
                ", j=" + j +
                ", privateString='" + privateString + '\'' +
                '}';
    }

    public MyObject(int i, int j)
    {
        this.i = i;
        this.j = j;
    }

    public void method1()
    {

    }

    private void method2()
    {

    }

    public void method3(int i)
    {

    }

    private int method4(int i, int j, int k)
    {
        return i+j+k;
    }

    private double method4(int i, double j, int k)
    {
        return i+j+k;
    }

}
