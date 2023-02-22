import java.util.*;
class Student implements Comparable<Student> {
    int grade;
// interface extends interface, inteface cannot implement interface
    public Student(int grade) {
        this.grade = grade;
    }
    public int compareTo(Student stu){
        return grade - stu.grade;
    }

    public String toString() {
        return "" + grade;
    }

}
public class App {
    public static void main(String[] args) throws Exception {
       /*  ArrayList<Student> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0;  i < 10; i++) {
            new Student(random.nextInt(100));
        }
        System.out.println(arrayList.toString());
        bubbleSort(arrayList);
        System.out.println(arrayList.toString()); */

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        Random random = new Random();
        for (int i = 0;  i < 10; i++) {
            arrayList.add(random.nextInt(100));
            arrayList2.add(random.nextInt(100));
        }
        System.out.println("Bubble Sort");
        System.out.println(arrayList.toString());
        bubbleSort(arrayList);
        System.out.println(arrayList.toString());
        System.out.println("Merge Sort");
        System.out.println(arrayList2.toString());
        mergeSort(arrayList2);
        System.out.println(arrayList2.toString());
    }
    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> a) {
        for (int j = a.size() - 1; j > 1; j--) {
            for (int i = 0; i < j; i++) {
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    E temp = a.get(i);
                    a.set(i, a.get(i+1));
                    a.set(i+1, temp);
                }
            }
        }
    }

    public static int [] createRandomArray(int arrayLength) {
        Random random = new Random();
        int[] a = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            a[i] = random.nextInt(0, 100);
        }
        return a;
    }

    public static <E extends Comparable<E>> void mergeArray(ArrayList<E> a, int start, int middle, int end) {
        int i = start;
        int j = middle;
        ArrayList<E> c = new ArrayList<>();
        while (i < middle && j < end) {
            if (a.get(i).compareTo(a.get(j)) <= 0 ) {
                c.add(a.get(i));
                i++;
            } else {
                c.add(a.get(j));
                j++;
            }
        }

        while (i < middle) {
            c.add(a.get(i));
            i++;
        }

        while (j < end) {
            c.add(a.get(j));
            j++;
        }

        for (i = start; i < end; i++) {
            a.set(i, c.get(i - start));
        }
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a, int start, int end) {
        if (end - start == 1) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle, end);
        mergeArray(a, start, middle, end);
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> a) {
        mergeSort(a, 0, a.size());
    }
}