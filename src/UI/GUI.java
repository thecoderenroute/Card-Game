package UI;

import Elements.Card;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUI extends Application {

    public void start() {
        launch(GUI.class);
    }

    @Override
    public void init() {
        gameState = gameStates.menu;
    }

    BorderPane layout;
    Button exit, play;

    enum gameStates {menu, playing, winning}

    gameStates gameState;

    @Override
    public void start(Stage stage) throws Exception {
        this.layout = new BorderPane();

        layout.setPrefSize(900, 750);
        layout.setBackground(new Background(new BackgroundFill(Color.web("#004d00"), null, null)));

        layout.setCenter(this.getMenu());

        Scene scene = new Scene(layout);

        BorderPane gameBoard = this.getGame();

        play.setOnAction((event) -> {
            gameState = gameStates.playing;
            layout.setCenter(gameBoard);
        });

        exit.setOnAction((event) -> {
            System.exit(0);
        });

        stage.setScene(scene);
        stage.show();
    }

    private BorderPane getGame() {

        BorderPane board = new BorderPane();
        board.setPadding(new Insets(20, 20, 20, 20));

        Label centre = new Label("Hand at Play");
        Label bottom = new Label("You");
        Label top = new Label("North");
        Label right = new Label("East");
        Label left = new Label("West");

        board.setCenter(centre);
        board.setBottom(bottom);
        board.setTop(top);
        board.setLeft(left);
        board.setRight(right);

        BorderPane.setAlignment(centre, Pos.CENTER);
        BorderPane.setAlignment(bottom, Pos.BOTTOM_CENTER);
        BorderPane.setAlignment(top, Pos.TOP_CENTER);
        BorderPane.setAlignment(right, Pos.CENTER_RIGHT);
        BorderPane.setAlignment(left, Pos.CENTER_LEFT);

        board.setCenter(new Card('H', '9').getImg());

        return board;
    }

    private VBox getMenu() {
        VBox menu = new VBox();
        menu.setSpacing(20);

        ArrayList<Button> buttons = new ArrayList<>();

        play = new Button("Play");
        exit = new Button("Exit");

        buttons.add(play);
        buttons.add(exit);

        for (Button button : buttons) {
            button.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(2))));
            button.setPrefSize(100, 24);
            button.setTextFill(Color.WHITE);
            button.setBackground(new Background(new BackgroundFill(Color.web("#004403"), new CornerRadii(5), null)));

            menu.getChildren().add(button);
        }


        menu.setAlignment(Pos.CENTER);

        return menu;
    }
}
