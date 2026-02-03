package day3_comparator_anonymous_class;

public class Student {
    private final String name;
    private final int age;
    private final double score;

    public Student(String name, int age, double score){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name is null or blank");
        }
        if(age <= 0){
            throw new IllegalArgumentException("Age must be > 0");
        }
        if(score <= 0){
            throw new IllegalArgumentException("Score must be > 0");
        }

        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
