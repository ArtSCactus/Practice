/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice.Module_6.Notepad;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ArtSCactus
 */
public class Note {

    /**
     * Contains topic of current note. Cannot be null.
     */
    private String topic;
    /**
     * Contains date and time of creation for current note.
     *
     */
    private Date creationDate;
    /**
     * Contains email for currentNote.
     *
     */
    private String email;
    /**
     * Contains main message of current note
     *
     */
    private String message;

    /**
     * Constructs new note object.
     *
     * @param topic
     * @param creationDate
     * @param email
     * @param message
     * @throws NullPointerException if atleast one of variables are null
     */
    public Note(Date creationDate, String email, String topic, String message) {
        if (topic == null | creationDate == null | email == null | message == null) {
            throw new NullPointerException("No one parameter of note cannot be null");
        }
        this.topic = topic;
        this.creationDate = creationDate;
        this.email = email;
        this.message = message;
    }

    /**
     * Returns topic of current note.
     *
     * @return
     */
    public String getTopic() {
        return topic;
    }

    /**
     * Settings new topic value.
     *
     * @param topic
     * @throws NullPointerException if topic are null
     */
    public void setTopic(String topic) {
        if (topic == null) {
            throw new NullPointerException("Topic cannot be null");
        }
        this.topic = topic;
    }

    /**
     * Returns date of cration for current note.
     *
     * @return
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Settings new date of creation for current object.
     *
     * @param creationDate
     * @throws NullPointerException if creationDate are null
     */
    public void setCreationDate(Date creationDate) {
        if (creationDate == null) {
            throw new NullPointerException("Cration date cannot be null");
        }
        this.creationDate = creationDate;
    }

    /**
     * Returns email of current note.
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Settings new email for current note.
     *
     * @param email
     * @throws NullPointerException if email are null
     */
    public void setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Email cannot be null");
        }
        this.email = email;
    }

    /**
     * Returns message of current note.
     *
     * @return
     */
    public String getMessage() {
        return message;
    }

    /**
     * Settings new message for current note.
     *
     * @param message
     * @throws NullPointerException if message are null
     */
    public void setMessage(String message) {
        if (message == null) {
            throw new NullPointerException("Message cannot be null");
        }
        this.message = message;
    }

    /**
     * Returns current note as String row.
     *
     * @return <code>creationDate.toString()+"|" +email+"|"+message</code>
     */
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(creationDate) + "|" + email + "|" + topic + "|" + message;
    }

}
