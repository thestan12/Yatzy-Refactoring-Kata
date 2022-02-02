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
        int[] counts = new int[6];
        for (int die : this.gamePlayer.numToArrays())
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public int ones() {
        int sum = 0;
        if (this.gamePlayer.getD1() == 1) sum++;
        if (this.gamePlayer.getD2() == 1) sum++;
        if (this.gamePlayer.getD3() == 1) sum++;
        if (this.gamePlayer.getD4() == 1) sum++;
        if (this.gamePlayer.getD5() == 1)
            sum++;

        return sum;
    }

    public int twos() {
        int sum = 0;
        if (this.gamePlayer.getD1() == 2) sum += 2;
        if (this.gamePlayer.getD2() == 2) sum += 2;
        if (this.gamePlayer.getD3() == 2) sum += 2;
        if (this.gamePlayer.getD4() == 2) sum += 2;
        if (this.gamePlayer.getD5() == 2) sum += 2;
        return sum;
    }

    public int threes() {
        int s;
        s = 0;
        if (this.gamePlayer.getD1() == 3) s += 3;
        if (this.gamePlayer.getD2() == 3) s += 3;
        if (this.gamePlayer.getD3() == 3) s += 3;
        if (this.gamePlayer.getD4() == 3) s += 3;
        if (this.gamePlayer.getD5() == 3) s += 3;
        return s;
    }

    public int fours()
    {
        int sum = 0;
        int[] dice = this.gamePlayer.numToArrays();
        for (int at = 0; at != 5; at++) {
            if (dice[at] == 4) {
                sum += 4;
            }
        }
        return sum;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < this.gamePlayer.numToArrays().length; i++)
            if (this.gamePlayer.numToArrays()[i] == 5)
                s = s + 5;
        return s;
    }

    public int sixes()
    {
        int sum = 0;
        for (int at = 0; at < this.gamePlayer.numToArrays().length; at++)
            if (this.gamePlayer.numToArrays()[at] == 6)
                sum = sum + 6;
        return sum;
    }

    public int score_pair()
    {
        int[] counts = new int[6];
        counts[this.gamePlayer.getD1()-1]++;
        counts[this.gamePlayer.getD2()-1]++;
        counts[this.gamePlayer.getD3()-1]++;
        counts[this.gamePlayer.getD4()-1]++;
        counts[this.gamePlayer.getD5()-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public int two_pair()
    {
        int[] counts = new int[6];
        counts[this.gamePlayer.getD1()-1]++;
        counts[this.gamePlayer.getD2()-1]++;
        counts[this.gamePlayer.getD3()-1]++;
        counts[this.gamePlayer.getD4()-1]++;
        counts[this.gamePlayer.getD5()-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int four_of_a_kind()
    {
        int[] tallies;
        tallies = new int[6];
        tallies[gamePlayer.getD1()-1]++;
        tallies[gamePlayer.getD2()-1]++;
        tallies[gamePlayer.getD3()-1]++;
        tallies[gamePlayer.getD4()-1]++;
        tallies[gamePlayer.getD5()-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public int three_of_a_kind()
    {
        int[] t;
        t = new int[6];
        t[gamePlayer.getD1()-1]++;
        t[gamePlayer.getD2()-1]++;
        t[gamePlayer.getD3()-1]++;
        t[gamePlayer.getD4()-1]++;
        t[gamePlayer.getD5()-1]++;
        for (int i = 0; i < 6; i++)
            if (t[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public int smallStraight()
    {
        int[] tallies;
        tallies = new int[6];
        tallies[gamePlayer.getD1()-1] += 1;
        tallies[gamePlayer.getD2()-1] += 1;
        tallies[gamePlayer.getD3()-1] += 1;
        tallies[gamePlayer.getD4()-1] += 1;
        tallies[gamePlayer.getD5()-1] += 1;
        if (tallies[0] == 1 &&
            tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1)
            return 15;
        return 0;
    }

    public int largeStraight()
    {
        int[] tallies;
        tallies = new int[6];
        tallies[gamePlayer.getD1()-1] += 1;
        tallies[gamePlayer.getD2()-1] += 1;
        tallies[gamePlayer.getD3()-1] += 1;
        tallies[gamePlayer.getD4()-1] += 1;
        tallies[gamePlayer.getD5()-1] += 1;
        if (tallies[1] == 1 &&
            tallies[2] == 1 &&
            tallies[3] == 1 &&
            tallies[4] == 1
            && tallies[5] == 1)
            return 20;
        return 0;
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
