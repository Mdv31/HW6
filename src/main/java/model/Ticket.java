package model;

/** Объект тикета (POJO) */
public class Ticket {

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDue_date() {
        return due_date;
    }

    public void setDue_date(String due_date) {
        this.due_date = due_date;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKbitem() {
        return kbitem;
    }

    public void setKbitem(int kbitem) {
        this.kbitem = kbitem;
    }

    public String[] getLast_escalation() {
        return last_escalation;
    }

    public void setLast_escalation(String[] last_escalation) {
        this.last_escalation = last_escalation;
    }

    public int getMerged_to() {
        return merged_to;
    }

    public void setMerged_to(int merged_to) {
        this.merged_to = merged_to;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public boolean[] getOn_hold() {
        return on_hold;
    }

    public void setOn_hold(boolean[] on_hold) {
        this.on_hold = on_hold;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSecret_key() {
        return secret_key;
    }

    public void setSecret_key(String secret_key) {
        this.secret_key = secret_key;
    }

    public String getSubmitter_email() {
        return submitter_email;
    }

    public void setSubmitter_email(String submitter_email) {
        this.submitter_email = submitter_email;
    }

    // todo: serialized поля, геттеры и сеттеры
    int id;
    String due_date;
    String assigned_to;
    String title;
    String created;
    String modified;
    String submitter_email;
    int status;
    boolean[] on_hold;
    String description;
    String resolution;
    int priority;
    String[] last_escalation;
    String secret_key;
    int queue;
    int kbitem;
    int merged_to;



    @Override
    public boolean equals(Object o) {
        // todo
        return false;
    }

    @Override
    public int hashCode() {
        // todo
        return 0;
    }
}
