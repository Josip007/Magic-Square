
public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here

        MagicSquareFactory factory = new MagicSquareFactory();
        MagicSquare ms = factory.createMagicSquare(5);
        if (ms != null) {
            System.out.println(ms);
        }
    }
}
