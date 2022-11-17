package hw24_Okt18_Input;
/*
1. Write a method fileCopy that takes two file names as input: file1 and file2. The method should make a copy of
the contents of file1 into file2. Note: file1 necessarily exists on disk.

2*. Write a method that cyclically looks through the contents of a given directory and prints information
about all files and directories in it and its subdirectories.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static final String PATH_1 = "../TelRan/Resource/file1.txt";
    public static final String PATH_2 = "../TelRan/Resource/file2.txt";
    public static final String PATH_3 = "../TelRan";

    public static void main(String[] args) throws IOException {
        fileCopy(PATH_1, PATH_2);
        File catalog = new File(PATH_3);
        contentsOfDirectory(catalog);
    }

    private static void fileCopy(String file1, String file2) throws IOException {
        FileInputStream fileInput = new FileInputStream(file1);
        FileOutputStream fileOutput = new FileOutputStream(file2);

        byte[] buffer = new byte[fileInput.available()];
        fileInput.read(buffer);
        fileInput.close();

        fileOutput.write(buffer);
        fileOutput.flush();
        fileOutput.close();
    }

    private static void contentsOfDirectory(File directory) {
        if (directory.isDirectory()) {
            for (File files : directory.listFiles()) {
                System.out.println(files.isFile() ?
                        "This file: " + files.getName() + " \nhas a path " + files.getAbsoluteFile() :
                        "Open the folder " + files.getName() + "/");
                contentsOfDirectory(files);
            }
        }
    }
}
