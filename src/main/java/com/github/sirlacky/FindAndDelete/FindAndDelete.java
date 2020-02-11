package main.java.com.github.sirlacky.FindAndDelete;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static main.java.com.github.sirlacky.FindAndDelete.FindDirectioriesClass.findDirectoriesWithSameName;

public class FindAndDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type file name:");
        String dictionaryName = scanner.nextLine();
        System.out.println("Type file path:");
        String filePath = scanner.nextLine();
        scanner.close();

        List<File> files = findDirectoriesWithSameName(dictionaryName, new File(filePath));

        int countNumberOfDeletedFiles = 0;
        for (File f : files) {
            try {
                countNumberOfDeletedFiles++;
                System.out.println("Deleting dictionary: " + f);
                FileUtils.forceDelete(f);
            } catch (IOException e) {
                System.out.println("No dictionaries - probably wrong pathname");
            }
        }
        System.out.println("Deleted: " + countNumberOfDeletedFiles + " dictionaries");
    }
}
