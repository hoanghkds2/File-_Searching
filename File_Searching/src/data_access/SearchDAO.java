package dataAccess;

import common.Validate;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SearchDAO {

    private static SearchDAO instance = null;
    Validate validate = new Validate();

    public static SearchDAO Instance() {
        if (instance == null) {
            synchronized (SearchDAO.class) {
                if (instance == null) {
                    instance = new SearchDAO();
                }
            }
        }
        return instance;
    }

    public int countWordInFile(String path, String word) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int count = 0;
            while (line != null) {
                String[] s = line.split(" ");
                for (String wd : s) {
                    if (wd.contains(word)) {
                        count++;
                    }
                }
                line = br.readLine();
            }
            return count;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void getFileNameContainsWordInDirectory(String path, String word) {
        File f = new File(path);
        File[] fs = f.listFiles();
        for (File file : fs) {
            if (file.isFile()) {
                if (countWordInFile(file.getAbsolutePath(), word) != 0) {
                    System.out.println("File name: " + file.getName());
                }
            }
        }
    }
}
