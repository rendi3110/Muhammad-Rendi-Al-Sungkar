import java.util.Scanner;

public class persegipanjang {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try (var input = new Scanner(System.in)) {
            System.out.print("Masukkan panjang persegi panjang: ");
            double panjang = input.nextDouble();

            System.out.print("Masukkan tinggi lebar persegi panjang: ");
            double lebar = input.nextDouble();

            double luas = panjang * lebar;

            System.out.println("Luas jajar genjang adalah: " + luas);
        }

    }
}