import java.util.Arrays;

public class Yatzy {

    private GamePlayer gamePlayer;

    private Yatzy(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
    }

    public static Yatzy initGamePlayer(int... dice){
        return new Yatzy(new GamePlayer(dice[0], dice[1], dice[2], dice[3], dice[4]));
    }

    /* Methodes */
    public int chance() {
        return Arrays.stream(gamePlayer.numToArrays()).sum();
    }

    public int yatzy()
    {
        return (this.gamePlayer.allNumHaveSameValue()) ? 50 : 0;
    }

    public int ones() {
        return (this.gamePlayer.allNumHaveIsEqualParam(1)) ? 0 : this.gamePlayer.countNumbers(1);
    }

    public int twos() {
        return (this.gamePlayer.allNumHaveIsEqualParam(1)) ? 2 : this.gamePlayer.countNumbers(2);
    }

    public int threes() {
        return (this.gamePlayer.allNumHaveIsEqualParam(3)) ? 2 : this.gamePlayer.countNumbers(3);
    }

    public int fours()
    {
        return (this.gamePlayer.allNumHaveIsEqualParam(4)) ? 2 : this.gamePlayer.countNumbers(4);
    }

    public int fives()
    {
        return (this.gamePlayer.allNumHaveIsEqualParam(5)) ? 2 : this.gamePlayer.countNumbers(5);
    }

    public int sixes()
    {
        return (this.gamePlayer.allNumHaveIsEqualParam(6)) ? 2 : this.gamePlayer.countNumbers(6);
    }

    public int score_pair()
    {
        return this.gamePlayer.plusGrandePaire(2)[0] * 2;
    }

    public int two_pair()
    {
        return this.gamePlayer.plusGrandePaire(2)[1] * 2 + this.gamePlayer.plusGrandePaire(2)[0] * 2;
    }

    public int four_of_a_kind()
    {
        return gamePlayer.getMaxValue(3) * 4;
    }

    public int three_of_a_kind()
    {
        return gamePlayer.getMaxValue(3) * 3;
    }

    public int smallStraight()
    {
        return gamePlayer.isSmallStraight() ? 15 : 0;
    }

    public int largeStraight()
    {
        return gamePlayer.isLargeStraight() ? 20 : 0;
    }

    public int fullHouse()
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;

        tallies = new int[6];
        tallies[gamePlayer.getD1()-1] += 1;
        tallies[gamePlayer.getD2()-1] += 1;
        tallies[gamePlayer.getD3()-1] += 1;
        tallies[gamePlayer.getD4()-1] += 1;
        tallies[gamePlayer.getD5()-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}
