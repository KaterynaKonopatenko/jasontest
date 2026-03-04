package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;


class File {
    String name;
    int size;
    String type;

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                '}';
    }
}

class FileCounter {
    int count;
    File[] files;

    boolean isCounterCorrect() {
        if (files == null) {
            return false;
        }
        return count == files.length;
    }

    @Override
    public String toString() {
        return "FileCounter{" +
                "count=" + count +
                ", files=" + Arrays.toString(files) +
                '}';
    }
}


public class App {

    static final String JSON = """
            {
              "count": 2,
              "files": [
                {"name": "1.txt", "size": 1234, "type": "txt"},
                {"name": "2.png", "size": 456, "type": "png"}
              ]
            }
            """;

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileCounter fileCounter = gson.fromJson(JSON, FileCounter.class);

        System.out.println(fileCounter.isCounterCorrect());
        fileCounter.count = 3;

        String s = gson.toJson(fileCounter);
        System.out.println(s);

    }
}
