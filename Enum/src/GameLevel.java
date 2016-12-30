public enum GameLevel {
    BEGINNER(0, "Начинающий"),
    PROFESSIONAL(1, "Профессионал"),
    HARD(2, "Бог");

    private int index;
    private String name;

    GameLevel(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}