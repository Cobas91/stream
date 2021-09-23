import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AppMain {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        Arrays.stream(numbers).sorted().forEach(System.out::println);
        System.out.println(Arrays.stream(numbers).sum());

        System.out.println(IntStream.of(numbers).reduce(1,(x, y)->x*y));

        //Erste Aufgabe
        try {
            Files.lines(Path.of("students.csv")).forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //Zweite Aufgabe
        try {
            Files.lines(Path.of("students.csv")).skip(1).forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try {
            Files.lines(Path.of("students.csv"))
                    .skip(1)
                    .filter(item-> !item.isEmpty())
                    .distinct()
                    .map(string -> string.split(","))
                    .map(array -> new Student(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3])))
                    .forEach(System.out::println);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
