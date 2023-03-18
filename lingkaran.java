import java.util.Scanner;

public class lingkaran {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        double phi = 3.14d;
        double r, luas, keliling;

        System.out.println("\t Hitung Luas & keliling Lingkaran \n");

        System.out.println("inputkan Jari-jari lingkaran : ");
        r = userInput.nextDouble();

        luas = phi * r * r;
        System.out.println(" \n Luas lingkaran      :" + luas);

        keliling = 2 * phi * r;
        System.out.println("\n keliling lingkaran :" + keliling);
    }
}
