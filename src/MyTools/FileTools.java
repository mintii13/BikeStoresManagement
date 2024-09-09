package MyTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class FileTools {

    public static void createNewFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File " + fileName + " already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + file.getName());
        } else {
            System.out.println("Failed to delete the file " + fileName);
        }
    }

    public static void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {;
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileListFromDir(String folderPath) {
        File folder = new File(folderPath);
        if (!folder.isDirectory()) {
            System.out.println("The provided path is not a directory or does not exist.");
            return;
        }
        File[] fileList = folder.listFiles();
        for (File f : fileList) {
            if (f.isFile()) {
                System.out.println("File: " + f.getName());
            } else if (f.isDirectory()) {
                System.out.println("Folder: " + f.getName());
            }
        }
    }

    public static List<Object> readObjectFromFile(String fileName) {
        List<Object> objectList = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    objectList.add(obj);
                } catch (EOFException e) {
                    break;
                }
            }
            return objectList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeObjectToFile(String fileName, List<?> objectList) {
        try
            (FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            for (Object obj : objectList) {
               oos.writeObject(obj);
               System.out.println("An object has been serialize to " + fileName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

}
