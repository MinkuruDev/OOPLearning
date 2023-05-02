package SV24.NguyenTrungVinh.GHP.UI;

import javax.swing.*;
public class SwitchForm {
    private JPanel switchPanel;
    private JButton studentButton;
    private JButton teacherButton;
    private JButton courseButton;
    private JButton examButton;
    private JButton documentButton;

    public enum SwitchButton{
        Student,
        Teacher,
        Course,
        Exam,
        Document
    }

    @FunctionalInterface
    public interface ButtonClick{
        public void onClick(SwitchButton button);
    }

    private ButtonClick onSwitchListener;
    public SwitchForm() {
        studentButton.addActionListener(e -> onSwitchListener.onClick(SwitchButton.Student));
        teacherButton.addActionListener(e -> onSwitchListener.onClick(SwitchButton.Teacher));
        courseButton.addActionListener(e -> onSwitchListener.onClick(SwitchButton.Course));
        examButton.addActionListener(e -> onSwitchListener.onClick(SwitchButton.Exam));
        documentButton.addActionListener(e -> onSwitchListener.onClick(SwitchButton.Document));
    }

    public void setOnSwitchListener(ButtonClick onSwitchListener) {
        this.onSwitchListener = onSwitchListener;
    }

    public JPanel getSwitchPanel() {
        return switchPanel;
    }
}
