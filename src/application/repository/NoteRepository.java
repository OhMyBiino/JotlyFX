package application.repository;

import application.db.DBConnection;
import application.model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteRepository {

    public List<Note> getAllNotes() {

        List<Note> notes = new ArrayList<>();
        String sql = "SELECT * FROM notes ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                notes.add(
                    new Note(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("last_edited")
                    )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return notes;
    }
    
    public void insert(Note note) {

        String sql =
            "INSERT INTO notes (title, content, last_edited) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.setString(3, note.getLastEdited());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void update(Note note) {

        String sql =
            "UPDATE notes SET title = ?, content = ?, last_edited = NOW() WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, note.getTitle());
            ps.setString(2, note.getContent());
            ps.setInt(3, note.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void delete(int id) {

        String sql = "DELETE FROM notes WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
