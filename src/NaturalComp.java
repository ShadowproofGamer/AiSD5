import java.util.Comparator;

public class NaturalComp implements Comparator<Integer> {
    public NaturalComp(){};
    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1, o2);
    }
}
