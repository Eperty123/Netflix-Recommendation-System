package dal.util;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FileHandler {
    private File inputFile;
    private List<String> inputLines = new ArrayList<>();
    private List<String> outputLines = new ArrayList<>();

    public void loadFile(String path) {
        File file = new File(path);

        try {
            if (file.exists()) {
                inputFile = file;
                BufferedReader br = new BufferedReader(new FileReader(file));

                String st;
                while ((st = br.readLine()) != null)
                    inputLines.add(st);

                outputLines = inputLines;
            }
        } catch (Exception e) {
            dal.util.MessageBox.Show(String.format("Load exception: %s", e.getMessage()), "Load Error", Alert.AlertType.ERROR);
        }
    }

    public void saveFile() {
        try {
            if (inputFile != null && inputFile.exists()) {
                FileWriter saver = new FileWriter(inputFile.getPath());
                BufferedWriter writer = new BufferedWriter(saver);

                for (String str : outputLines)
                    writer.write(str + "\n");

                writer.close();
            }
        } catch (Exception e) {
            MessageBox.Show(String.format("Save exception: %s", e.getMessage()), "Save Error", Alert.AlertType.ERROR);
        }
    }


    public void addRange(Collection<String> c) {
        for (var t : c) outputLines.add(t + "\n");
    }

    public List<String> getInputLines() {
        return inputLines;
    }

    public List<String> getOutputLines() {
        return outputLines;
    }
}
