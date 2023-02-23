package CreateSample_Calendar;
import java.time.LocalDate;
import java.io.File;
import java.io.IOException;

class AdventTemple{
    public static void main(String[] args) {
        String mainRoot="AdventOfCode";
        final String[] tails = {"output.cpp","output.java","output.py","PuzzleInput.txt"};
        final int year=2024;
        CalendarCreator.createOneCalendars(mainRoot, tails, year);
    }
}
class CalendarCreator{
    public static void createAllCalendars(final String mainRoot, final String[] tails){
        int currentYear = LocalDate.now().getYear();
        for(int year=2015; year<=currentYear; year++){
            String level1="Advent_of_code_"+String.valueOf(year);
            File dir1=new File(mainRoot+File.separator+level1);
            FileGenerator.CreateFolder(dir1);
            for(int date=1; date<=25; date++){
                String level2=level1+"_"+String.valueOf(date);
                File dir2=new File(mainRoot+File.separator+level1+File.separator+level2);
                FileGenerator.CreateFolder(dir2);
                for(String tail:tails){
                    String file1=level2+tail;
                    FileGenerator.CreateFile(mainRoot,level1,level2,file1);
                }
            }
        }
    }
    public static void createOneCalendars(final String mainRoot, final String[] tails, final int year){
        String level1="Advent_of_code_"+String.valueOf(year);
        File dir1=new File(mainRoot+File.separator+level1);
        FileGenerator.CreateFolder(dir1);
        for(int date=1; date<=25; date++){
            String level2=level1+"_"+String.valueOf(date);
            File dir2=new File(mainRoot+File.separator+level1+File.separator+level2);
            FileGenerator.CreateFolder(dir2);
            for(String tail:tails){
                String file1=level2+tail;
                FileGenerator.CreateFile(mainRoot,level1,level2,file1);
            }
        }
    }
}
class FileGenerator{
    public static void CreateFile(String mainRoot, String level1, String level2, String fileName){
        File ParentFile=new File(mainRoot+File.separator+level1+File.separator+level2);
        File file = new File(ParentFile, fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }
    public static void CreateFolder(File directory) {
        if (!directory.exists()) {
            directory.mkdir();
          }
    }
}