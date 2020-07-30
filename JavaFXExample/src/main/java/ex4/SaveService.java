package ex4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SaveService {
    //сщитает и сохраняет статистику
    final static String FILE_NAME = "save/save.txt";
    ArrayList<String> correctSave = new ArrayList<>();
    AtomicInteger correctAll = new AtomicInteger(0); //правильный
    AtomicInteger correct = new AtomicInteger(0); // правильных correctAll
    AtomicInteger correctNo = new AtomicInteger(0);

    int wrongAll = 0;

    public void load() {
        if (Files.exists(Paths.get(FILE_NAME))) {
            try {
                List<Integer> loadSave = Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8) //
                        .map(Integer::valueOf).collect(Collectors.toList());
                correctAll.set(loadSave.get(0));
                correctNo.set(loadSave.get(1));

                wrongAll = loadSave.get(1);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void createAndSave() {
        if (!Files.exists(Paths.get("save"))) {
            try {
                Files.createDirectories(Paths.get("save"));
                correctSave.add(String.valueOf(correct.get()));
                correctSave.add(String.valueOf(correctNo.get()));
                Files.write(Paths.get(FILE_NAME), correctSave, StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                correctSave.add(String.valueOf(correctAll.get() + correct.get()));
                correctSave.add(String.valueOf(correctNo.get()));
                Files.write(Paths.get(FILE_NAME), correctSave, StandardCharsets.UTF_8);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
