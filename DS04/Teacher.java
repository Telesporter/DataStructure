package DataStructure.DS04;

/**
 * Created with IntelliJ IDEA.
 * User: 13498
 * Date: 2021/12/9
 * Time: 16:44
 * Description: No Description
 */
public class Teacher {
    public String id;
    public String name;

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Teacher)){
            return false;
        }
        Teacher teacher = (Teacher)obj;
        return this.id.equals(teacher.id);
    }
}
