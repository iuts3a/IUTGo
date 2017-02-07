package IUTGo.Models;

public class Comment {

    private String message;
    private Integer grade;

    public String getMessage() {
        return message;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Comment(String message, Integer grade) {
        this.message = message;
        this.grade = grade;
    }
}
