package main.java.com.github.sirlacky.FindAndDelete;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static main.java.com.github.sirlacky.FindAndDelete.FindDirectioriesClass.findDirectoriesWithSameName;
import static main.java.com.github.sirlacky.FindAndDelete.FindDirectioriesClass.testFunctionality;

public class FindAndDelete {
    public static void main(String[] args) {

        System.out.println("\nThis app will help you to search all directories with given name and then delete it.\n" +
                "GitHub: github.com/SirLacky\n" +
                "Please note that scanning will take a while (1TB LAN HDD took about 2 hours to scan\n" +
                "Choose what you want to do: ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - TEST, 0 - FIND AND DESTROY");
        long startTime = System.currentTimeMillis();
        int start = scanner.nextInt();
        if (start == 1) {
            scanner.close();
            testFunctionality();
        } else if (start == 0) {
            System.out.println("Type file name:");
            String dictionaryName = scanner.nextLine();
            dictionaryName = scanner.nextLine();
            System.out.println("Type file path:");
            String filePath = scanner.nextLine();
            List<File> files = findDirectoriesWithSameName(dictionaryName, new File(filePath));
            scanner.close();
            int countNumberOfDeletedFiles = 0;
            for (File f : files) {
                try {
                    countNumberOfDeletedFiles++;
                    System.out.println("Deleting dictionary: " + f);
                    FileUtils.forceDelete(f);
                } catch (IOException e) {
                    System.out.println("No dictionaries - probably wrong pathname or parent directory was same name");
                }
            }
            System.err.println("Deleted: " + countNumberOfDeletedFiles + " directories");
        } else {
            System.out.println("Incorrect input");
        }
        long endTime = System.currentTimeMillis();
        System.err.println("Total time needed: " + (endTime - startTime) / 1000 + " secounds");
    }
}
