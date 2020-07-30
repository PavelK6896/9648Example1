package ex4;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Trainer2 extends Application {
    LogicService logicService = new LogicService();
    SaveService saveService = new SaveService();
    Text questionText;
    Text answerText;
    Text hintText; //подсказка
    Text allCountSessionRightAnswer;
    Text allCountSessionWrong;
    Text allCountWrong;
    Text allCountRightAnswer;

    Button btnNext;
    Button btnHint;
    Group group;
    Scene scene;

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Start");

        questionText = new Text(200, 200, "");
        questionText.setStyle("-fx-font: 50 arial;");
        answerText = new Text(200, 250, "");
        answerText.setStyle("-fx-font: 36 arial;");
        hintText = new Text(200, 400, "");
        hintText.setStyle("-fx-font: 36 arial;");

        allCountRightAnswer = new Text(300, 20, "всего правильных ");
        allCountWrong = new Text(450, 20, "всего неправильных ");

        allCountSessionRightAnswer = new Text(300, 50, "правильных ");
        allCountSessionRightAnswer.setStyle("-fx-font: 36 arial;");

        allCountSessionWrong = new Text(300, 100, "неправильных ");
        allCountSessionWrong.setStyle("-fx-font: 36 arial;");

        //       Text t6 = new Text(200, 65, "пропусков ");

        btnNext = new Button();
        btnNext.setText("Next");
        btnNext.setLayoutY(40);
        btnNext.setLayoutX(40);

        btnHint = new Button(); // подсказка hint
        btnHint.setText("Hint");
        btnHint.setLayoutY(100);
        btnHint.setLayoutX(40);

        group = new Group(questionText, btnNext, btnHint, answerText, hintText, allCountWrong,
                allCountRightAnswer, allCountSessionRightAnswer, allCountSessionWrong);
        saveService.load();
        allCountRightAnswer.setText("всего правильных " + saveService.correctAll.get());
        allCountWrong.setText("всего неправильных " + saveService.wrongAll);

        scene = new Scene(group, 800, 500, Color.rgb(200, 250, 180));
        btnNext.setMinSize(100, 50);
        btnHint.setMinSize(100, 50);

        questionText.setText(logicService.nextExample());
        hintText.setText("");
        System.out.println("logicService.answerStr " + logicService.answerStr);
        btnNext.setOnAction(e -> {
            questionText.setText(logicService.nextExample());
            hintText.setText("");
            System.out.println("logicService.answerStr " + logicService.answerStr);
        });
        btnHint.setOnAction(e -> hintText.setText(logicService.answerStr));


        scene.setOnKeyTyped(ke -> {
            //  System.out.println(ke.getCharacter().getBytes()[0]);
            if (ke.getCharacter().getBytes()[0] == 8) {
                answerText.setText("");
                return;
            }

            if (ke.getCharacter().getBytes()[0] == 32) {
                // btnNext.fire();
                answerText.setText("");
                return;
            }


            if (ke.getCharacter().getBytes()[0] == 13) {
                btnHint.fire();
                answerText.setText("");
                return;
            }

            answerText.setText(answerText.getText() + ke.getCharacter());

            if (logicService.answerStr.length() == answerText.getText().length()) {//если ответ равен длине правильного

                if (logicService.checkAnswer(answerText.getText())) {
                    allCountSessionRightAnswer.setText("правильных " + saveService.correct.incrementAndGet());
                    questionText.setText(logicService.nextExample());//следующий
                    hintText.setText("");
                } else {
                    allCountSessionWrong.setText("неправильных " + saveService.correctNo.incrementAndGet());
                    allCountWrong.setText("всего неправильных " + ++saveService.wrongAll);
                }
                answerText.setText("");
            }
        });

        stage.setScene(scene);
        stage.setTitle("Trainer2");
        stage.setOnCloseRequest(event222 -> {
            System.out.println("Close");
            saveService.createAndSave();
        });
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}
