package IUTGo.Models;

import java.io.Serializable;

public class Comment implements Serializable
{
    private String  message;
    private Integer grade;
    
    public Comment (String message, Integer grade)
    {
        setMessage(message);
        setGrade(grade);
    }
    
    //region Getters and Setters
    public String getMessage ()
    {
        return message;
    }
    
    private void setMessage (String message)
    {
        this.message = message;
    }
    
    public Integer getGrade ()
    {
        return grade;
    }
    
    private void setGrade (Integer grade)
    {
        this.grade = grade;
    }
    //endregion
    
    @Override
    public String toString ()
    {
        return "Comment{" + "grade='" + getGrade() + '\'' + ", comment=" + getMessage() + '}';
    }
}
