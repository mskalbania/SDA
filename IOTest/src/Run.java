import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Run {

    public static void main(String[] args) {

        BinaryIO binaryIO = new BinaryIO();
        binaryIO.fillMap(500);

        BinaryIO binaryNIO = new JavaNIO();
        binaryNIO.fillMap(500);
        try {
            long start = System.currentTimeMillis();
            binaryNIO.writeMapToExternalFile();
            System.out.println("Execution time NIO was : " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            binaryIO.writeMapToExternalFile();
            System.out.println("Execution time IO was : " + (System.currentTimeMillis() - start));

        } catch (IOException e) {
            e.printStackTrace();
        }


//        binaryIO.fillMap(100);
//        showMap(binaryIO.getRandomList());
//
//        binaryIO.fillSet(100);
//        showSet(binaryIO.getBooks());

//        try {
//            //binaryIO.writeSetToExternalFile();
//            showSet(binaryIO.readSetFromExternalFile());
//
//        }catch (IOException | ClassNotFoundException e){
//            e.printStackTrace();
//        }
//
//        try {
//            binaryIO.writeMapToExternalFile();
//            showMap(binaryIO.readMapFromExternalFile());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }

    public static void showMap(Map<String, String> input) {
        for (Map.Entry<String, String> map : input.entrySet()) {
            System.out.println(map.getKey() + " - > " + map.getValue());
        }
    }

    public static void showSet(Set<Book> input) {
        for (Book book : input) {
            System.out.println(book.getAuthor() + " - >" + book.getTitle());
        }
    }
}
