import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable {
    String name; // will be serialized
    int age; // will be serialized
    transient String desc; // will not be serialized
    final transient String b = "buddu"; // final compile time constants are serialized

    @Override
    public String toString() {
        return name + " " + age + " " + desc + " " + b;
    }
}

public class Transient {

    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Arjit";
        e.age = 29;
        e.desc = "Ghuggu";

        //System.out.println(e.toString());
        //serialize(e);
        Employee a = deserialize();
        System.out.println(a.toString());
    }

    public static void serialize(Employee e) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("empInfo.ser"));
            oos.writeObject(e);
            oos.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static Employee deserialize() {
        try {
           ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("empInfo.ser"));
           //Read the object back
           Employee readEmpInfo = (Employee) ooi.readObject();
           ooi.close();
           return readEmpInfo;
        } catch (Exception e)
        {
           System.out.println(e);
           return null;
        }
    }
}
