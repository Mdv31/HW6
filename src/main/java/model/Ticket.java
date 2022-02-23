package model;

/** Объект тикета (POJO) */
public class Ticket {

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
