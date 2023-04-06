import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MobilListApp {

    static String fileName;
    static ArrayList<String> mobilLists;
    static boolean isEditing = false;
    static Scanner input;

    public static void main(String[] args) {
        // initialize
        mobilLists = new ArrayList<>();
        input = new Scanner(System.in);

        String filePath = System.console() == null ? "/src/mobillist.txt" : "/mobillist.txt";
        fileName = System.getProperty("user.dir") + filePath;

        System.out.println("FILE: " + fileName);

        // run the program
        while (true) {
            showMenu();
        }
    }

    static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            } else {
                // clear screen untuk Linux, Unix, Mac
                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }

    }

    static void showMenu() {
        System.out.println("=== LIST MOBIL ===");
        System.out.println("[1] Lihat Mobil List");
        System.out.println("[2] Tambah Mobil List");
        System.out.println("[3] Edit Mobil List");
        System.out.println("[4] Hapus Mobil List");
        System.out.println("[0] Keluar");
        System.out.println("---------------------");
        System.out.print("Pilih menu> ");

        String selectedMenu = input.nextLine();

        if (selectedMenu.equals("1")) {
            showMobilList();
        } else if (selectedMenu.equals("2")) {
            addMobilList();

        } else if (selectedMenu.equals("3")) {
            editMobilList();

        } else if (selectedMenu.equals("4")) {
            deleteMobilList();
        } else if (selectedMenu.equals("0")) {
            System.exit(0);
        } else {
            System.out.println("Kamu salah pilih menu!");
            backToMenu();
        }
    }

    static void backToMenu() {
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali..");
        input.nextLine();
        clearScreen();
    }

    static void readMobilList() {
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            // load isi file ke dalam array todoLists
            todoLists.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                mobilLists.add(data);

            }

        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }

    static void showMobilList() {
        clearScreen();
        readMobilList();
        if (todoLists.size() > 0) {
            System.out.println("MOBIL LIST:");
            int index = 0;
            for (String data : mobilLists) {
                System.out.println(String.format("[%d] %s", index, data));
                index++;
            }
        } else {
            System.out.println("Tidak ada data!");
        }

        if (!isEditing) {
            backToMenu();
        }
    }

    static void addMobilList() {
        clearScreen();

        System.out.println("Mobil apa yang ingin kamu rental?");
        System.out.print("Jawab: ");
        String newTodoList = input.nextLine();

        try {
            // tulis file
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(String.format("%s%n", newMobilList));
            fileWriter.close();

            System.out.println("Berhasil ditambahkan!");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
        backToMenu();
    }

    static void editMobilList() {
        isEditing = true;
        showMobilList();

        try {
            System.out.println("-----------------");
            System.out.print("Pilih Indeks> ");
            int index = Integer.parseInt(input.nextLine());

            if (index > mobilLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
            } else {

                System.out.print("Data baru: ");
                String newData = input.nextLine();

                // update data
                todoLists.set(index, newData);

                System.out.println(mobilLists.toString());

                try {
                    FileWriter fileWriter = new FileWriter(fileName, false);

                    // write new data
                    for (String data : todoLists) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();

                    System.out.println("Berhasil diubah!");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        isEditing = false;
        backToMenu();
    }

    static void deleteMobilList() {
        isEditing = true;
        showMobilList();

        System.out.println("-----------------");
        System.out.print("Pilih Indeks> ");
        int index = Integer.parseInt(input.nextLine());

        try {
            if (index > mobilLists.size()) {
                throw new IndexOutOfBoundsException("Kamu memasukan data yang salah!");
            } else {

                System.out.println("Kamu akan menghapus:");
                System.out.println(String.format("[%d] %s", index, todoLists.get(index)));
                System.out.println("Apa kamu yakin?");
                System.out.print("Jawab (y/t): ");
                String jawab = input.nextLine();

                if (jawab.equalsIgnoreCase("y")) {
                    todoLists.remove(index);

                    // tulis ulang file
                    try {
                        FileWriter fileWriter = new FileWriter(fileName, false);

                        // write new data
                        for (String data : mobilLists) {
                            fileWriter.append(String.format("%s%n", data));
                        }
                        fileWriter.close();

                        System.out.println("Berhasil dihapus!");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan karena: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        isEditing = false;
        backToMenu();
    }

}
