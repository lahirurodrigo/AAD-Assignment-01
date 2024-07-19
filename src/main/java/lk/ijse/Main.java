package lk.ijse;

import java.io.*;

public class Main implements Serializable {

    public int a;
    public String b;


    public Main(int a, String b) {
        this.a = a;
        this.b = b;
    }

}

class Demo {
    public static void main(String[] args) {
        Main object = new Main(1, "lahiru");
        String filename = "file.ser";

        // Serialization

        try {
            // first save the object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(object);

            out.close();
            file.close();

            System.out.println("Object has been serialized.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        Main object1 = null;


        // Deserialization
        try {
            // Reading the object from the file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method of the deserialization of object
            object1 = (Main) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized.");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}