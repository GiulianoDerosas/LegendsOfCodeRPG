package main;

public class Enemy extends Character{

    int playerXp;

//    This constructor uses a set of algorithms to determine the enemies maxHP & experience.
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + playerXp/3 + 5), (int) (Math.random() * (playerXp/4 + 2) + 1));
        this.playerXp = playerXp;
    }


//    Enemy specific methods
//    Changed 4 to 2 in playerXP division as the enemies were doing consistently low damage.
//    Changed 4 to 3 in XP division as the enemies were doing consistently low damage.
//    Finally changed the division to zero for testing, enemy was consistently doing too little damage.
    @Override
    public int attack() {
        return (int) (Math.random()*(playerXp + 1) + xp/3 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random()*(playerXp + 1) + xp/4 + 3);
    }
    //    ______________________________________________________________________________


}
