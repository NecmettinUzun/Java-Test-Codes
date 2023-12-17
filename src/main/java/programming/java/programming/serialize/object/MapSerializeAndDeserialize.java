package programming.java.programming.serialize.object;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

class Student implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String            name;
    private String            surname;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", surname=" + surname + "]";
    }
    
    
}

public class MapSerializeAndDeserialize {

    private final static String FILE = "resources/serializedStudent.txt";

    public static void main(String[] args) {

//        serializeMap();
        deserializeMap();
    }

    private static void serializeMap() {
        Map<Integer, Student> studentData = new HashMap<Integer, Student>();
        studentData.put(1, new Student("Ali", "Veli"));
        studentData.put(2, new Student("Ali2", "Veli2"));

        File file = new File(FILE);
        try (OutputStream output = new FileOutputStream(file);
                ObjectOutputStream objectOutput = new ObjectOutputStream(output)) {
            objectOutput.writeObject(studentData);
            objectOutput.flush();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        System.out.println("Map serialized into this file " + file.getAbsolutePath());
    }
    
    private static void deserializeMap() {
        
        Map<Integer, Student> studentData = new HashMap<Integer, Student>();
        
        File file = new File(FILE);
        try(InputStream input = new FileInputStream(file);
                ObjectInputStream objectInput = new ObjectInputStream(input)) {
            
            studentData=  (Map<Integer, Student>) objectInput.readObject();
            
            System.out.println("Deserialized Map " + studentData);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
