package Controller;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GameController extends Component {
    public List<String> loadGameFromFile(String path) {
        try {
            List<String> chessData = Files.readAllLines(Path.of(path));
            /**chessboard.loadGame(chessData);
             return chessData;*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
