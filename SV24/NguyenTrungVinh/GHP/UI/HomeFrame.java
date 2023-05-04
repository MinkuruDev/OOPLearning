package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.DataWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomeFrame extends JFrame{
    private JPanel leftPanel, rightPanel;
    private JTable mainTable;
    private SwitchForm.SwitchButton currentPanel = SwitchForm.SwitchButton.Student;
    private final StudentForm studentForm = new StudentForm();
    private final TeacherForm teacherForm = new TeacherForm();
    private final CourseForm courseForm = new CourseForm();
    private final ExamForm examForm = new ExamForm();
    private final DocumentForm documentForm = new DocumentForm();
    public HomeFrame(){
        this.setLayout(new BorderLayout(10, 25));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH | this.getExtendedState()); 
        this.setTitle("Quản lý trung tâm ngoại ngữ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setComponent();
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DataWriter.writeAll();
                super.windowClosing(e);
            }
        });
    }

    public void setLeftPanelContent(JPanel content){
        leftPanel.removeAll();
        leftPanel.add(content, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }

    public void setRightPanelContent(JPanel content){
        rightPanel.removeAll();
        rightPanel.add(content, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }

    private void setComponent(){
        mainTable = new JTable();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        rightPanel.setLayout(new BorderLayout());
        this.add(leftPanel, BorderLayout.WEST);
        this.add(new JScrollPane(mainTable), BorderLayout.CENTER);
        this.add(rightPanel, BorderLayout.EAST);

        this.setLeftPanelContent(studentForm.getStudentInfoPanel());
        this.setRightPanelContent(studentForm.getStudentSearchPanel());

        SwitchForm switchForm = new SwitchForm();
        switchForm.setOnSwitchListener(button -> {
            currentPanel = button;
            updateUI();
        });

        studentForm.setDataChangeListener(
                (data, props) -> mainTable.setModel(
                        new DefaultTableModel(data, props)));
        teacherForm.setDataChangeListener(
                (data, props) -> mainTable.setModel(
                        new DefaultTableModel(data, props)));
        courseForm.setOnDataChangeListener(
                (data, props) -> mainTable.setModel(
                        new DefaultTableModel(data, props)));
        examForm.setOnDataChangeListener(
                (data, props) -> mainTable.setModel(
                        new DefaultTableModel(data, props)));
        documentForm.setOnDataChangeListener(
                (data, props) -> mainTable.setModel(
                        new DefaultTableModel(data, props)));

        mainTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                int col = target.getSelectedColumn();

                switch (currentPanel){
                    case Student -> studentForm.onTableCellSelected(row, col);
                    case Teacher -> teacherForm.onTableCellSelected(row, col);
                    case Course -> courseForm.onTableCellSelected(row, col);
                    case Exam -> examForm.onTableCellSelected(row, col);
                    case Document -> documentForm.onTableCellSelected(row, col);
                }
            }
        });

        mainTable.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point point = e.getPoint();
                int col = mainTable.columnAtPoint(point);

                switch (currentPanel){
                    case Student -> studentForm.sortByColumn(col);
                    case Teacher -> teacherForm.sortByColumn(col);
                    case Course -> courseForm.sortByColumn(col);
                    case Exam -> examForm.sortByColumn(col);
                    case Document -> documentForm.sortByColumn(col);
                }
            }
        });

        this.add(switchForm.getSwitchPanel(), BorderLayout.NORTH);
        updateUI();
    }

    private void updateUI(){
        switch (currentPanel){
            case Student -> onStudentSwitch();
            case Teacher -> onTeacherSwitch();
            case Course -> onCourseSwitch();
            case Exam -> onExamSwitch();
            case Document -> onDocumentSwitch();
        }
        System.gc();
    }

    private void onStudentSwitch(){
        this.setLeftPanelContent(studentForm.getStudentInfoPanel());
        this.setRightPanelContent(studentForm.getStudentSearchPanel());
        studentForm.update();
    }

    private void onTeacherSwitch(){
        this.setLeftPanelContent(teacherForm.getTeacherInfoPanel());
        this.setRightPanelContent(teacherForm.getTeacherSearchPanel());
        teacherForm.update();
    }

    private void onCourseSwitch(){
        this.setLeftPanelContent(courseForm.getCourseInfoPanel());
        this.setRightPanelContent(courseForm.getSearchPanel());
        courseForm.update();
    }

    private void onExamSwitch(){
        this.setLeftPanelContent(examForm.getExamInfoPanel());
        this.setRightPanelContent(examForm.getExamSearchPanel());
        examForm.update();
    }

    private void onDocumentSwitch(){
        this.setLeftPanelContent(documentForm.getDocumentInfoPanel());
        this.setRightPanelContent(documentForm.getDocumentSearchPanel());
        documentForm.update();
    }
}
