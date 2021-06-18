package main;

public class Enemy extends Character{

    int playerXp;

//    This constructor uses a set of algorithms to determine the enemies maxHP & experience.
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + playerXp/3 + 5), (int) (Math.random() * (playerXp/4 + 2) + 1));
        this.playerXp = playerXp;
    }


//    Enemy specific methods
    @Override
    public int attack() {
        return 0;
    }

    @Override
    public int defend() {
        return 0;
    }


}
