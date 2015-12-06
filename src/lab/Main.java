package lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * Created by eugeny on 03.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Masha","Doll",100,15));
        toys.add(new Toy("Lego 1","Constructor", 250,100));
        toys.add(new Toy("Big Ball","Ball",150,75));
        toys.add(new Toy("Dasha","Doll",200,25));

        print(toys);
        writeToTexFile(toys, "toys.txt");
        writeToBinaryFile(toys, "toys.dat");
        List<Toy> toys1 = readFromBinaryFile("toys.dat");
        System.out.println("=========================");
        print(toys1);
        System.out.println("=========================");
        printByType(toys, "Doll");
        System.out.println("=========================");
        printByType(toys);
    }

    private void printByType(List<Toy> toys) {
        Map<String, List<Toy>> collect = toys.stream().collect(groupingBy(t -> t.getType()));
        for (Map.Entry<String, List<Toy>> entry : collect.entrySet()) {
            System.out.println("--" + entry.getKey() + "--");
            print(entry.getValue());
        }
    }

    private void printByType(List<Toy> toys, String type) {
        List<Toy> collect = toys.stream().filter(t -> t.getType().equals(type)).collect(toList());
        print(collect);
    }

    private List<Toy> readFromBinaryFile(String filename) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            Object o = objectInputStream.readObject();
            return (List<Toy>) o;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void writeToBinaryFile(List<Toy> toys, String filename) {
        try (ObjectOutputStream  objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(toys);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToTexFile(List<Toy> toys, String filename) {
        try (PrintWriter out = new PrintWriter(filename)) {
            toys.forEach(out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void print(List<Toy> toys) {
        toys.stream().forEach(System.out::println);
    }
}
