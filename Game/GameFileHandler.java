package Game;

import java.io.*;

public class GameFileHandler {

    public static void saveGame(Player player, String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(player);
        }
    }

    public static Player loadGame(String filePath) throws IOException, ClassNotFoundException {
        Player player;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            player = (Player) ois.readObject();
        }
        return player;
    }
}
