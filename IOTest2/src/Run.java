import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {
//        String fileName = "./src/someFile";
//        File f1 = new File(fileName);
//        try {
//            f1.createNewFile();
//            Thread.sleep(10000);
//            f1.delete();
//            System.out.println(String.format("Is %s a directory? : " + f1.isDirectory(), f1.getName()));
//            System.out.println(String.format("Path of %s is : " + f1.getCanonicalPath(), f1.getName()));
//        } catch (IOException /*| InterruptedException */e) {
//            System.out.println("IOE");
//        }
//        //File dir1 = new File("./dir1");
//        //dir1.mkdir();
//        f1.delete();
//          File f2 = new File("./dir1/newSomeFile.txt");
//        try {
//            f2.createNewFile();
//        } catch (IOException e) {
//            System.out.println("IOE " + e.getMessage());
//        }

        File f3 = new File("./dir1/newSomeFile.txt");
        try {
            f3.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f3));
             BufferedOutputStream out = new BufferedOutputStream
                     (new FileOutputStream("copy.txt"))) {

            while (in.available() > 0){
             out.write(in.read());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

//        try (BufferedWriter bf = new BufferedWriter(new FileWriter(f3))) {
//            bf.write("AAAAAAAAAAAA");
//        } catch (IOException ioe) {
//            System.out.println("IOE" + ioe.getMessage());
//        }
//
//        try (DataOutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3, true)))) {
//            os.writeUTF("Mateusz Skałbania");
//        } catch (IOException ioe) {
//            System.out.println("IOE" + ioe.getMessage());
//        }

        File f4 = new File("/home/mateusz/Desktop/SDA/IOTest2/");
        List<String> fileList = new ArrayList<>();
        listRecursive(f4, fileList);
        for (String string : fileList) {
            System.out.println(string);
        }
    }

    public static void listRecursive(File dir, List<String> list) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    list.add(file.getAbsolutePath());
                    if (file.isDirectory()) {
                        listRecursive(file, list);
                    }
                }
            }
        }
    }
}
