package SV24.NguyenTrungVinh.GHP.Obj;

import SV24.NguyenTrungVinh.GHP.XmlElement.Exams;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.time.LocalDateTime;

@XmlRootElement
public class Exam {
    private String examName;
    private String certificateName;
    private LocalDateTime examDateTime;
    @XmlElement
    private String examTime;
    private int durationInMinutes;
    private long price;

    public Exam(){
        Exams.addExam(this);
    }

    public String getCertificateName() {
        return certificateName;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @XmlTransient
    public LocalDateTime getExamDateTime() {
        if(examDateTime == null)
            examDateTime = LocalDateTime.parse(examTime);
        return examDateTime;
    }

    public String getExamName() {
        return examName;
    }

    public Exam setCertificateName(String certificateName) {
        this.certificateName = certificateName;
        return this;
    }

    public Exam setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
        return this;
    }

    public Exam setExamDateTime(LocalDateTime examDateTime) {
        this.examDateTime = examDateTime;
        this.examTime = examDateTime.toString();
        return this;
    }

    public Exam setExamName(String examName) {
        this.examName = examName;
        return this;
    }

    public Exam setPrice(long price) {
        this.price = price;
        return this;
    }

    public long getPrice() {
        return price;
    }
}
