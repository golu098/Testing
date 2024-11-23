package restAssured;

public class Body {
    int userID;
    int id;
    String title;
    boolean completed;
public Body(){};
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Body(int userID, int id, String title, boolean completed){
        this.userID=userID;
        this.id=id;
        this.title=title;
        this.completed=completed;
    }

}
