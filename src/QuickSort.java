import java.util.AbstractList;
import java.util.Comparator;
import java.util.Random;

public class QuickSort<T> {
    private Comparator<T> _comparator;
    private Random random;

    public QuickSort(Comparator<T> comparator) {
        _comparator = comparator;
        random = new Random();
    }

    public AbstractList<T> sort(AbstractList<T> list) {
        quicksort(list, 0, list.size());
        return list;
    }

    private void quicksort(AbstractList<T> list, int startIndex, int endIndex) {
        if (endIndex - startIndex > 1) {
            int partition = partition(list, startIndex, endIndex);
            quicksort(list, startIndex, partition);
            quicksort(list, partition + 1, endIndex);
        }
    }

    private int partition(AbstractList<T> list, int nFrom, int nTo) {
        //bierzemy losowy element dzielący (dla kolekcji > 100 średnia z 3 losowych elementów)

        int rnd = nFrom + random.nextInt(nTo - nFrom);
        if (nTo - nFrom > 100) {
            int rnd1 = nFrom + random.nextInt(nTo - nFrom);
            int rnd2 = nFrom + random.nextInt(nTo - nFrom);
            int rnd3 = nFrom + random.nextInt(nTo - nFrom);
            rnd = (rnd1 + rnd2 + rnd3) / 3;
        }

        swap(list, nFrom, rnd);
        T value = list.get(nFrom);
        int idxBigger = nFrom + 1, idxLower = nTo - 1;
        do {
            while (idxBigger <= idxLower && _comparator.compare(list.get(idxBigger), value) <= 0) idxBigger++;
            while (_comparator.compare(list.get(idxLower), value) > 0) idxLower--;
            if (idxBigger < idxLower) swap(list, idxBigger, idxLower);
        } while (idxBigger < idxLower);
        swap(list, idxLower, nFrom);
        return idxLower;
    }

    private void swap(AbstractList<T> list, int left, int right) {
        if (left != right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
        }
    }
}
