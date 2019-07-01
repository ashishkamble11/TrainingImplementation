import java.util.*;

class Student
{
    Integer id; String name;

    public Student(Integer id, String name)
    {
        this.id = id;
        this.name = name;
    }

}

public class CollectionConversion
{
    public static void main(String[] args)
    {
        Queue queue = new LinkedList();
        queue.add("a");queue.add("b");
        queue.add("c");queue.add("d");

        List list = new ArrayList(queue);
        System.out.println(list);

        Set set=new LinkedHashSet(list);
        System.out.println(set);

        Vector vector=new Vector(list);
        System.out.println(vector);

        Queue queue1=new PriorityQueue(list);
        System.out.println(queue1);

        List<Student> lt=new LinkedList();
        lt.add(new Student(1,"Ashish"));
        lt.add(new Student(2,"Shubham"));
        lt.add(new Student(3,"Karan"));
        Map<Integer, String> map=new HashMap<>();
        for(Student student: lt)
        {
            map.put(student.id, student.name);
        }
        System.out.println(map);
    }
}
