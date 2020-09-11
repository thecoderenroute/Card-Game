package UI;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        stage.setScene(scene);
        stage.show();
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

        play.setOnAction((event) -> {
            gameState = gameStates.playing;
        });

        exit.setOnAction((event) -> {
            System.exit(0);
        });

        menu.setAlignment(Pos.CENTER);

        return menu;
    }
}
