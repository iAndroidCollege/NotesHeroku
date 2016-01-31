package entities;

public class Note {
    public String title;
    public String note;
    public int id;

    public Note(String title, String note, int id) {
        this.title = title;
        this.note = note;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
    }
}
