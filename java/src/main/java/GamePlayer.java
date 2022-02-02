
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GamePlayer {
    private int d1;
    private int d2;
    private int d3;
    private int d4;
    private int d5;

    public GamePlayer() {

    }

    public GamePlayer(int d1, int d2, int d3, int d4, int d5) {
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
        this.d4 = d4;
        this.d5 = d5;
    }

    public int[] numToArrays(){
        return new int[]{ d1, d2, d3, d4, d5 };
    }

    public boolean allNumHaveSameValue(){
        return Arrays.stream(this.numToArrays()).min().orElse(0) == Arrays.stream(this.numToArrays()).max().orElse(0);
    }

    public int getMaxValue(int valueBrelan){

        int response = 0;
        Map<Integer, Integer> tailles = scorePairesTotal();

        for (Integer key: tailles.keySet()){
            if(tailles.get(key) >= valueBrelan){
                response = key;
            }
        }

        return response;
    }

    public int[] plusGrandePaire(int integer){
        Map<Integer, Integer> tailles = scorePairesTotal();
        int maxPair = 0;
        int secondeMaxPair = 0;

        for (Integer key: tailles.keySet()){
            Integer value = tailles.get(key);

            if(value >= integer && key >= maxPair){
                secondeMaxPair = maxPair;
                maxPair = key;
            }
        }

        return new int[]{maxPair, secondeMaxPair};
    }


    private Map<Integer, Integer> scorePairesTotal(){

        Map<Integer, Integer> tailles = new HashMap<>();

        for (Integer i : this.numToArrays()){
            if(!tailles.containsKey(i)){
                tailles.put(i, 0);
            }
            tailles.put(i, tailles.get(i) + 1);
        }

        return tailles;
    }

    private boolean isStraight(){
        return Arrays.stream(this.numToArrays()).distinct().count() == Arrays.stream(this.numToArrays()).count();
    }

    public boolean isSmallStraight(){
        return isStraight() && Arrays.stream(this.numToArrays()).min().orElse(0) == 1 && Arrays.stream(this.numToArrays()).max().orElse(0) == 5;
    }

    public boolean isLargeStraight(){
        return isStraight() && Arrays.stream(this.numToArrays()).min().orElse(0) == 2 && Arrays.stream(this.numToArrays()).max().orElse(0) == 6;
    }

    public boolean allNumHaveTheSame(){
        return Arrays.stream(this.numToArrays()).min().orElse(0) == Arrays.stream(this.numToArrays()).max().orElse(0);
    }


    public boolean allNumHaveIsEqualParam(int num){
        return this.allNumHaveSameValue() && this.getD1() == num;
    }

    public int countNumbers(int number){
        return Arrays.stream(this.numToArrays()).filter(num->num == number).sum();
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public int getD3() {
        return d3;
    }

    public void setD3(int d3) {
        this.d3 = d3;
    }

    public int getD4() {
        return d4;
    }

    public void setD4(int d4) {
        this.d4 = d4;
    }

    public int getD5() {
        return d5;
    }

    public void setD5(int d5) {
        this.d5 = d5;
    }
}
