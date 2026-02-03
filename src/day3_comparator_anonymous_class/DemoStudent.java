package day3_comparator_anonymous_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DemoStudent {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        // score 9.5 (3 bạn) -> age tăng dần: 18, 19, 22
        list.add(new Student("An", 22, 9.5));
        list.add(new Student("Binh", 18, 9.5));
        list.add(new Student("Chi", 19, 9.5));

        // score 9.0 (3 bạn) -> age tăng dần: 18, 20, 25
        list.add(new Student("Dung", 25, 9.0));
        list.add(new Student("Huy", 20, 9.0));
        list.add(new Student("Khanh", 18, 9.0));

        // score 8.0 (4 bạn) -> age tăng dần: 17, 19, 20, 21
        list.add(new Student("Long", 21, 8.0));
        list.add(new Student("Minh", 17, 8.0));
        list.add(new Student("Nam", 20, 8.0));
        list.add(new Student("Phuc", 19, 8.0));

        System.out.println("=== Before sort ===");
        for (Student s : list) System.out.println(s);

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int scoreCmp = Double.compare(o2.getScore(), o1.getScore());
                if(scoreCmp != 0) return scoreCmp;

                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        System.out.println("=== After sort ===");
        for (Student s : list) System.out.println(s);

    }
}
