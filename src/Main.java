public class Main
{
    public static void main(String[] args) {
        Tombola tomb = new Tombola("Grena");
        Tombola tomb2 = new Tombola("Bernini");
        tomb.start();
        tomb2.start();
    }
}