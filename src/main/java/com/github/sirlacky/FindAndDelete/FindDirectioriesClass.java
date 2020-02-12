package main.java.com.github.sirlacky.FindAndDelete;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindDirectioriesClass {
    public static List<File> findDirectoriesWithSameName(String name, File root) {
        List<File> result = new ArrayList<>();

        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                if (file.getName().equals(name)) {
                    result.add(file);
                }
                result.addAll(findDirectoriesWithSameName(name, file));
            }
        }
        return result;
    }

    public static void testFunctionality() {
        //code creates and deletes directory test in out directory
        File file = new File("out\\test");

        boolean bool = file.mkdir();
        if (bool) {
            System.out.println("\nDirectory created successfully in destination: " + file.getAbsolutePath());
        } else {
            System.out.println("\nFailed to create directory - destination path already taken, try again. Failed path:\n"+ file.getAbsolutePath());
        }
        String test = file.getParent();
        List<File> files = findDirectoriesWithSameName("test", new File(file.getParent()));
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
        System.err.println("Deleted: " + countNumberOfDeletedFiles + " dictionaries - TEST");
    }
}
