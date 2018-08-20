package generic;


import annotation_and_reflection.MyObject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Foo<T>
{
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}






public class Main {




    public static <T> boolean findElementInList (T ob, List<T> elements)
    {
        for (T element : elements)
        {
            if ( element.equals(ob) )
            {
                return true;
            }
        }

        return false;
    }


    public static <T> void swap(T[] ar, int i, int j)
    {
        T temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static <T> void sort(List<T> elements, Comparator<T> comparator)
    {
        int len = elements.size();
        for (int i = 0; i < len; i++)
        {
            int swapIdx = i;
            for (int j = i+1; j < len; j++)
            {
                if ( comparator.compareto(elements.get(i), elements.get(j)) <= 0 )
                {
                    swapIdx = j;
                }
            }
            Collections.swap(elements, i, swapIdx);
        }
    }

    public void printType(Integer i)
    {
        System.out.println("Integer");
    }





    public static void main(String[] args) {

        Class mainClass = Main.class;
        System.out.println(mainClass);

        String className = mainClass.getName();
        System.out.println(className);

        int modifiers = mainClass.getModifiers();
        System.out.println(modifiers);

        Package pack = mainClass.getPackage();
        System.out.println(pack);

        Class superClass = mainClass.getSuperclass();
        System.out.println( superClass );

        Class myObjectClass = MyObject.class;
        Class[] interfaces = myObjectClass.getInterfaces();
        System.out.println( Arrays.toString(interfaces) );

        Annotation[] annotations = myObjectClass.getAnnotations();
        System.out.println( Arrays.toString(annotations) );

        Constructor[] constructors = myObjectClass.getConstructors();
        System.out.println( Arrays.toString(constructors) );

        try
        {
            Constructor constructor = myObjectClass.getConstructor(int.class, int.class);
            System.out.println(constructor);

            Class[] parameterTypes = constructor.getParameterTypes();
            System.out.println( Arrays.toString(parameterTypes) );

            MyObject myObject = (MyObject) constructor.newInstance(1, 2);
            System.out.println(myObject);

            Field[] fields = myObjectClass.getFields();
            System.out.println( Arrays.toString(fields) );

            Field field = myObjectClass.getField("i");
            System.out.println(field);

            String fieldName = field.getName();
            System.out.println(fieldName);

            Class fieldType = field.getType();
            System.out.println( fieldType );

            field.set(myObject, -1);
            System.out.println(myObject);

            Object value = field.get(myObject);
            System.out.println(value);

            Field privateStringField = myObjectClass.getDeclaredField("privateString");
            privateStringField.setAccessible(true);
            privateStringField.set(myObject, "Nafee");
            System.out.println("Set the field name to Nafee");

//            privateStringField.setAccessible(false);
            String fieldValue = (String) privateStringField.get(myObject);

            Field[] declaredFields = myObjectClass.getDeclaredFields();
            System.out.println( Arrays.toString(declaredFields) );

            System.out.println(fieldValue);

            Method[] methods = myObjectClass.getDeclaredMethods();
            System.out.println(Arrays.toString(methods));

            methods = myObjectClass.getMethods();
            System.out.println( Arrays.toString(methods) );

            Method method = myObjectClass.getDeclaredMethod("method4", new Class[]{int.class, double.class, int.class});
            System.out.println(method);

            parameterTypes = method.getParameterTypes();
            System.out.println(Arrays.toString(parameterTypes));

            Class returnType = method.getReturnType();
            System.out.println(returnType);

            method.setAccessible(true);
            Object returnValue = method.invoke(myObject, 1, 2, 3);
            System.out.println(returnValue);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}

