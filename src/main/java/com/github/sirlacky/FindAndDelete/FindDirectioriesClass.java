package main.java.com.github.sirlacky.FindAndDelete;

import java.io.File;
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
}
