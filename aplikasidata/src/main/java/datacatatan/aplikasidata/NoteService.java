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

public class NoteService {
    private DataStorage storage;

    public NoteService(DataStorage storage) {
        this.storage = storage;
    }

    public void createNote(String note) {
        storage.writeData(note);
    }

    public List<String> readNotes() {
        return storage.readData();
    }

    public void deleteNote(String note) {
        storage.deleteData(note);
    }
}
