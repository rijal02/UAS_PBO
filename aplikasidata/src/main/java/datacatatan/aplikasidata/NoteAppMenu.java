/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datacatatan.aplikasidata;

/**
 *
 * @author rizal
 */
import java.util.List;
import java.util.Scanner;

public class NoteAppMenu {
    private NoteService noteService;
    private Scanner scanner;

    public NoteAppMenu(String databasePath) {
        noteService = new NoteService(new DatabaseStorage(databasePath));
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("APLIKASI CATATAN DATA");
            System.out.println("=======================");
            System.out.println("Pilihan Menu:");
            System.out.println("1. Tambah data");
            System.out.println("2. Tampilkan data");
            System.out.println("3. Hapus data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu 1/2/3/4: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addNote();
                    break;
                case 2:
                    showNotes();
                    break;
                case 3:
                    deleteNote();
                    break;
                case 4:
                    System.out.println("Keluar.");
                    return;
                default:
                    System.out.println("Pilihan tidak tersedia, pilih yang tersedia di Menu.");
                    break;
            }
        }
    }

    private void addNote() {
        System.out.print("Masukkan data: ");
        String note = scanner.nextLine();
        noteService.createNote(note);
        System.out.println("Data berhasil disimpan: " + note);
    }

    private void deleteNote() {
        System.out.print("Masukkan data yang akan dihapus: ");
        String note = scanner.nextLine();
        noteService.deleteNote(note);
        System.out.println("Data yang dihapus: " + note);
    }

    private void showNotes() {
        List<String> notes = noteService.readNotes();
        System.out.println("Data yang tersimpan:");
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan data.");
        } else {
            for (String note : notes) {
                System.out.println(note);
            }
        }
    }
}
