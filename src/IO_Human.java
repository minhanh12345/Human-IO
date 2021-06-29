import java.io.*;
import java.util.ArrayList;

public class IO_Human {
    static ArrayList<Human> list = new ArrayList<>();
    static File human = new File("human.txt");

    public static void main(String[] args) throws IOException {

     docFile();
     for (Human human:list){
         System.out.println(human);
     }
    }

    public static void ghiFile() throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            FileWriter fileWriter = new FileWriter(human);
            bufferedWriter =new BufferedWriter(fileWriter);
            for (Human human : list) {
                bufferedWriter.write(human.toString());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
        }
    }

    public static void docFile() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(human);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 4) {
                    list.add(new Human(str[0], Integer.parseInt(str[1]), str[2], Integer.parseInt(str[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            bufferedReader.close();
        }

    }
}
