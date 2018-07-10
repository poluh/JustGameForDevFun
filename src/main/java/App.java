import Engine.Engine;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        var group = new GridPane();
        var scene = new Scene(group, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        var engine = new Engine();
        engine.loadTextures("/Users/sergejpoluhin/IdeaProjects/TextureCreator/Textures");
        group.getChildren().addAll(engine.getCanvases());
    }
}
