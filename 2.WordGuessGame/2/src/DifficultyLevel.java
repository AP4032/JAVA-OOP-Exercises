public enum DifficultyLevel {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private final int multiplier;

    DifficultyLevel(int multiplier) {
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }
}
