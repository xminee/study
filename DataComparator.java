package iterator_comparator;

import java.util.Comparator;


public class DataComparator implements Comparator<DoubleLinkedListNode<Double>> {

    @Override
    public int compare(DoubleLinkedListNode<Double> n1, DoubleLinkedListNode<Double> n2) {
        double value1 = n1.getData();
        double value2 = n2.getData();

        if (value1 < value2) {
            return -1;
        } else if (value1 > value2) {
            return 1;
        } else {
            return 0;
        }
    }
}
