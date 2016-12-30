public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < GameLevel.values().length; i++) {
            System.out.println(GameLevel.values()[i].getName());
        }

        Game game = new Game();
        game.setGameLevel(GameLevel.BEGINNER);

        System.out.println("game.getGameLevel() = " + game.getGameLevel());

        if (game.getGameLevel() == GameLevel.BEGINNER) {
            System.out.println("Beginner");
        }

        System.out.println("index: " + game.getGameLevel().getIndex());
    }
}