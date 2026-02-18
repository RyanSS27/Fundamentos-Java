import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Luta ufc = new Luta();
        Combatentes[] lutadores = {
                new Combatentes("Pretty Boy", 68.9f, (short) 11, (short) 1, (short) 3),
                new Combatentes("Putscript", 57.8f, (short) 14, (short) 3, (short) 2),
                new Combatentes("Snapshadow", 80.9f, (short) 12, (short) 1, (short) 2),
                new Combatentes("Dead Code", 81.6f, (short) 13, (short) 2, (short) 0)
        };
        for (int i = 0; i < 5; i++) {
            for (int j = 0; i < 5; i++) {
                ufc.marcarLuta(lutadores[i], lutadores[j], sc);

            }
        }

    }
}