import java.util.Comparator;
import java.util.Random;

public class BucketSort<T> {
    //TODO
    private Comparator<T> _comparator;
    private Random random;
    public BucketSort(Comparator<T> comparator) {
        _comparator = comparator;
        random = new Random();
    }


}
