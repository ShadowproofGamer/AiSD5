import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //zad2();
        //zad4();
        //bst_test();

    }
    private static void zad2(){
        //zad2
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arr.add(random.nextInt(10000000));
        }
        QuickSort<Integer> qs = new QuickSort<>(new NaturalComp());
        qs.sort(arr);
        //System.out.println(arr);
    }
    private static void bst_test(){
        BST bst = new BST();
/*
        bst.insert(20);
        bst.insert(7);
        bst.insert(10);
        bst.insert(25);
        bst.insert(4);
        bst.insert(1);
        bst.insert(2);
        bst.insert(12);
        bst.insert(30);
        bst.delete(12);
        bst.delete(1);
        bst.delete(20);
*/
        bst.load();

        System.out.println("inorder:");
        bst.inorder();
        System.out.println("\npreorder:");
        bst.preorder();
        System.out.println("\npostorder:");
        bst.postorder();

        int minval = bst.findMin();
        System.out.println("\nminimum: "+minval);
        int maxval = bst.findMax();
        System.out.println("maximum: "+maxval);
        //boolean ret_val = bst.search (50);
        //System.out.println("\nKey 50 found in BST:" + ret_val );
        //ret_val = bst.search (30);
        //System.out.println("\nKey 30 found in BST:" + ret_val );
        int xvc = bst.count();
        System.out.println("\nNodes number in BST: "+xvc);
        int h = bst.heightCount();
        System.out.println("\nBST height: "+h);
        int even = bst.countEven();
        System.out.println("\nEven nodes number in BST: "+even);
        int one = bst.countOneChild();
        System.out.println("\nOne child nodes number in BST: "+one);
        int bro = bst.countOneBro();
        System.out.println("\nOne bro nodes number in BST: "+bro);
        int och = bst.countOneChildHeight();
        System.out.println("\nOne child height node number in BST: "+och);

        bst.save();
        System.out.println("\nBST saved.");
        bst.load();
        System.out.println("BST loaded.");

        System.out.println("\ninorder:");
        bst.inorder();
        System.out.println("\n\npreorder:");
        bst.preorder();
        System.out.println("\n\npostorder:");
        bst.postorder();



    }
    private static void zad4(){
        Hashtable<Integer, Student> ht = new Hashtable();
        Student s1 = new Student(20, "Jan", "Brzechwa", "Wroclaw University of Technology");
        Student s2 = new Student(20, "Marcin", "Jarz??bina", "Wroclaw University of Technology");
        Student s3 = new Student(21, "Andrzej", "D??b", "Krakow University of Technology");
        Student s4 = new Student(23, "Karol", "Popi????", "Wroclaw Medical School");
        Student s5 = new Student(20, "Jan", "Kami??ski", "Wroclaw University of Technology");
        ht.put(1, s1);
        ht.put(2, s2);
        ht.put(3, s3);
        ht.put(4, s4);
        ht.put(5, s5);
        System.out.println(ht.get(1));


    }
}
