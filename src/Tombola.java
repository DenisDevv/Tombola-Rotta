import java.util.Random;
public class Tombola extends Thread {
    private static int[] disponibili = new int[90];
    private static int disponibiliVirtuale = 90;
    private static Random randomizzatore = new Random();
    private String nome;
    public Tombola(String n) {
        for (int i = 0;i<disponibiliVirtuale;i++) {
            disponibili[i] = i+1;
        }
        nome = n;
    }
    private int genera() {
        int numeroCasuale = randomizzatore.nextInt(disponibiliVirtuale);
        // Metto in pausa il thread per 1 secondo
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numeroCasuale;
    }
    public int estrai() {
        if (disponibiliVirtuale == 0) {
            return -1;
        } else {
            int numero = genera();
            // Metto in pausa il thread per 1 secondo
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int estratto = disponibili[numero];
            disponibili[numero] = disponibili[disponibiliVirtuale-1];
            // Metto in pausa il thread per 1.5 secondi
            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            disponibiliVirtuale--;
            return estratto;
        }
    }
    public void run() {
        for (int i = 0; i<91; i++) {
            int ris = estrai();
            if(ris == -1) {
                System.out.println(nome + " ha finito i numeri da estrarre.");
                break;
            } else {
                System.out.println(nome + " ha estratto " + ris);
            }
        }
    }
}