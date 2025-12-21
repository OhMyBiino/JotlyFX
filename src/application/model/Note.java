package application.model;

public class Note {
    private int id;
    private String title;
    private String content;
    private String lastEdited;

    public Note(int id, String title, String content, String lastEdited) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.lastEdited = lastEdited;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public String getLastEdited() { return lastEdited; }
}
