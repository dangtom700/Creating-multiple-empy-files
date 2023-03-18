package CreateSamples;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.io.FileWriter;

public class create_condense_advent {
    public static void create_condense_file(final String main_root, final int year){
        String fileName="Advent_of_code_"+String.valueOf(year)+".java";
        File file = new File(main_root, fileName);
        try {
            file.createNewFile();
            FileWriter myWriter = new FileWriter(file);
            myWriter.write("package "+main_root+";\n");
            myWriter.write("public class " + "Advent_of_code_" + String.valueOf(year) + "{\n");
            myWriter.write("\tpublic static void main(String[] args){\n");
            myWriter.write("\n");
            myWriter.write("\t}\n");
            myWriter.write("}\n");
            myWriter.close();
        } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        final String main_root="advent";
        final int currentYear = LocalDate.now().getYear();
        for (int year = 2015; year <= currentYear; year++){
            create_condense_file(main_root, year);
            System.out.println("Successful created");
        }
    }
}