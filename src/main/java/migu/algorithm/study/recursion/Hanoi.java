package migu.algorithm.study.recursion;

public class Hanoi {
    private void HanoiMove(int num, int from, int by, int to) {
        if (num == 1) {
            printHanoiMove(num, from, to);
        } else {
            HanoiMove(num - 1, from, to, by);
            printHanoiMove(num, from, to);
            HanoiMove(num - 1, by, from, to);
        }
    }

    private void printHanoiMove(int num, int from, int to) {
        System.out.printf("moved disk %d from column %d to column %d\n", num, from, to);
    }

    public static void main(String[] args) {
        new Hanoi().HanoiMove(2,1,2,3);
        System.out.println("--------------------");
        new Hanoi().HanoiMove(3,1,2,3);
    }
}
