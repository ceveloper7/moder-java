package ch03;

import java.io.*;

public class ExecuteAround {
    private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();
    public static void main(String[] args) throws IOException {
        // solo retorna una linea
        String result = processFileLimited();
        System.out.println(result);

        System.out.println("--------");
        // pasamos la implementacion del metodo abstracto process de la interface funcional BufferedReaderProcessor
        processFile((BufferedReader br)->{
            String line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        } );

    }

    public static void processFile(BufferedReaderProcessor p) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            p.process(br);
        }
    }

    public static String processFileLimited()throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(FILE))){
            return br.readLine();
        }
    }
}
