package ch05;

import model.Trader;
import model.Transaction;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class FDemo {

    private static List<Transaction> getTransactions(){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        return Arrays.asList(
                new Transaction(brian, 2011, 900),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    /*
     * Case 1: Encontrar todas las transacciones del 2011 y ordenarlas por su valor (ascendente)
     */
    private static void getTransactionsByYear(List<Transaction> transactions){
        List<Transaction> tr2011 = transactions.stream()
                // pasamos el predicado a filtrar: obtener las transacciones del anio 2011
                .filter(transaction -> transaction.getYear() == 2011)
                // Ordenamos la transacciones filtradas usando el valor de la transaccion
                .sorted(Comparator.comparing(Transaction::getValue))
                // recolectamos el resultado del stream y pasamos a un List
                .collect(toList());
        System.out.println(tr2011);
    }

    /*
     * Case 2: Cuales son las ciudades donde los traders trabajan
     */
    private static void getCityTraders(List<Transaction> transactions){
        List<String> cities = transactions.stream()
                // Extraer la ciudad de cada trader asociado a una transaccion
                .map(transaction -> transaction.getTrader().getCity())
                // descartamos las ciudades duplicadas. En lugar de distinct() se podria usar collect(toSet())
                // y devolvemos un Set con las ciudades sin duplicados.
                .distinct()
                .collect(toList());
        System.out.println(cities);
    }

    /*
     * Case 3: Obtener todos los traders de la ciudad de Cambridge y ordenarlos por el nombre
     */
    private static void getTraderFromCity(List<Transaction> transactions){
        List<Trader> traders = transactions.stream()
                // Obtenemos todos los traders del stream transactions
                .map(Transaction::getTrader)
                // seleccionamos unicamente los traders de la ciudad de Cambridge
                .filter(trader -> "Cambridge".contentEquals(trader.getCity()))
                // removemos cualquier duplicado
                .distinct()
                // ordenamos el stream de traders resultante por su nombre
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);
    }

    /*
     * Case 4: Obtener como una cadena los nombres de los traders, ordenados alfabeticamente
     * Esta solucion es ineficiente (todas la cadenas estan repetidamente concatenadas, lo cual crear un nuevo string
     * en cada iteracion)
     */
    private static void getTradersName(List<Transaction> transactions){
        String traderStr = transactions.stream()
                // extraemos todos los nombres de los traders como un Stream de String
                .map(transaction -> transaction.getTrader().getName())
                // descartamos los nombres duplicados
                .distinct()
                // ordenamos los nombres alfabeticamente
                .sorted()
                // combinamos los nombres uno por uno para formar un String que concatena todos los nombres
                .reduce("", (n1, n2) -> n1 + " " +n2);
        System.out.println(traderStr);
    }

    /*
     * Case 5: Existe algun trader en la ciudad de Milan
     */
    private static void isThereAnyTraderInMilan(List<Transaction> transactions){
        boolean milanBased = transactions.stream()
                // Pasamos un predicado a la operacion anyMatch(), verificamos si hay un trader en la ciudad de Milan.
                .anyMatch(transaction -> "Milan".contentEquals(transaction.getTrader().getCity()));
        System.out.println(milanBased);
    }

    /*
     * Case 6: Imprimir el valor de las transacciones de los traders de la ciudad de Cambridge
     */
    private static void printTransactionValueInCambridge(List<Transaction> transactions){
        transactions.stream()
                // seleccionamos las transacciones donde el trader viva en Cambridge
                .filter(t -> "Cambridge".contentEquals(t.getTrader().getCity()))
                // obtenemos el valor de las transacciones de los traders de Cambridge
                .map(Transaction::getValue)
                // impresion de valores
                .forEach(System.out::println);
    }

    /*
     * Case 7: Obtener el valor mas alto entre las transacciones
     */
    private static void getTransactionMaxValue(List<Transaction> transactions){
        int highestValue = transactions.stream()
                // extraemos el valor de cada transaccion
                .map(Transaction::getValue)
                // calculamos el mayor valor entre las transacciones
                .reduce(0, Integer::max);
        System.out.println(highestValue);
    }

    /*
     * Case 8: Obtener la transaccion que posee el menor valor
     */
    private static void getTransactionWithMinValue(List<Transaction> transactions){
        // Find the transaction with the smallest value
        Optional<Transaction> smallestTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        // Here I cheat a bit by converting the found Transaction (if any) to a String
        // so that I can use a default String if no transactions are found (i.e. the Stream is empty).
        System.out.println(smallestTransaction.map(String::valueOf).orElse("No transactions found"));
    }

    public static void main(String[] args) {
        getTransactionWithMinValue(getTransactions());
        //getTransactionMaxValue(getTransactions());
        //printTransactionValueInCambridge(getTransactions());
        //isThereAnyTraderInMilan(getTransactions());
        //getTradersName(getTransactions());
        //getTraderFromCity(getTransactions());
        //getCityTraders(getTransactions());
        //getTransactionsByYear(getTransactions());
    }
}
