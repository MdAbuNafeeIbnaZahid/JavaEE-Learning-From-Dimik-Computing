package generic;

public class StringComparator implements Comparator<String> {

    @Override
    public int compareto(String ob1, String ob2) {
        return ob1.length() - ob2.length();
    }
}
