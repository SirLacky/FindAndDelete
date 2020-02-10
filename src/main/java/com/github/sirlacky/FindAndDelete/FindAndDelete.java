package main.java.com.github.sirlacky.FindAndDelete;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static main.java.com.github.sirlacky.FindAndDelete.FindDirectioriesClass.findDirectoriesWithSameName;

public class FindAndDelete {
    public static void main(String[] args) {

        //Put dictionary name as first parameter and path as second;
        List<File> files = findDirectoriesWithSameName("NAME OF DICTIONARY", new File("PATH TO DICTIONARY TO SCAN"));

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
