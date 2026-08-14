package day13_team.model.Dto;

public class QnaDto {

    private int no;
    private String question;
    private String writer;
    // 2. 기본생성자, 전체매개변수생성자
    public QnaDto() { }
    public QnaDto(int no, String question, String writer) {
        this.no = no;
        this.question= question;
        this.writer = writer;
    }
    // 3. setter and getter , toString 
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question= question;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    @Override
    public String toString() {
        return "QnaDto [no=" + no + ", question=" + question+ ", writer=" + writer + "]";
    }
} // CLASS END 
