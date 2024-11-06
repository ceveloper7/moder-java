package ch05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * Stream.of() permite crear un stream con valores explicitos.
 */
public class HBuildingStream {

    private static void buildingStreamFromValues() {
        Stream<String> stream = Stream.of(
                "Modern",
                "Java",
                "In",
                "Action"
        );

        stream.map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void buildingStreamFromNull(){
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));
        homeValueStream.forEach(System.out::println);
    }

    private static void buildingStreamFromArray(){
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    private static void buildingStreamFromFile(){
        long uniqueWords = 0;
        // usamos try with resources
        try(Stream<String> lines = Files.lines(Paths.get(
                "/home/ceva/magna-carta.txt"), Charset.defaultCharset())){
            uniqueWords = lines
                    // generamos un stream con las palabras del archivo
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    // removemos las palabras duplicadas del stream
                    .distinct()
                    // contamos el numero de palabras unicas
                    .count();
        }catch (IOException e){}

        System.out.println(uniqueWords);
    }

    private static void buildingStreamFromFunction(){
        // valor inicial 0
        // usamos una lambda de tipo UnaryOperator
        Stream.iterate(0, i -> i + 1)
                .limit(10) // limitamos el stream a 10 elementos
                .forEach(System.out::println);

        System.out.println(

        );
        // print los primeros 10 valores pares
        Stream.iterate(0, i -> i + 2)
                .limit(10)
                .forEach(System.out::println);

        /*
         * Serie Tuplas Fibonacci
         *
         */
        Stream.iterate(new int[]{0,1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + ", " + t[1] + ")"));
    }

    // generamos numeros iniciando desde 0 pero detiene la iteracion una vez que n es mayor que 100
    private static void iterateWithPredicate(){
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        System.out.println();

        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
    }

    /*
     * generate() produce un stream infinito de valores pero generate() no aplica sucesivamente una funcion a cada nuevo valor producido.
     * Se necesita una lambda de tipo Supplier<T>
     */
    private static void generateRandomNums(){
        Stream.generate(()-> (int) (Math.random() * 10000000))
                .limit(5)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        generateRandomNums();
        //iterateWithPredicate();
        //buildingStreamFromFunction();
        //buildingStreamFromFile();
        //buildingStreamFromArray();
        //buildingStreamFromNull();
        //buildingStreamFromValues();
    }
}
