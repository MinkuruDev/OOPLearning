package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.DataChecker;
import SV24.NguyenTrungVinh.GHP.Data.DataViewer;
import SV24.NguyenTrungVinh.GHP.Data.DataWriter;
import SV24.NguyenTrungVinh.GHP.Obj.Course;
import SV24.NguyenTrungVinh.GHP.Obj.FunctionalInterfaces;
import SV24.NguyenTrungVinh.GHP.Obj.Teacher;
import SV24.NguyenTrungVinh.GHP.Obj.TimesInWeek;
import SV24.NguyenTrungVinh.GHP.XmlElement.Courses;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CourseForm {
    private JTextField nameField;
    private JTextField startField;
    private JTextField endField;
    private JTextField teacherField;
    private JButton editScheduleButton;
    private JTextArea studentArea;
    private JPanel courseInfoPanel;
    private JTextField priceField;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton addButton;
    private JPanel searchPanel;
    private JTextField searchName;
    private JTextField upperStart;
    private JTextField lowerStart;
    private JTextField upperFinish;
    private JTextField lowerFinnish;
    private JTextField searchTeacher;
    private JTextField upperStCount;
    private JTextField upperPrice;
    private JTextField lowerPrice;
    private JButton clearSearchResultButton;
    private JButton findButton;
    private JTextField lowerStCount;

    private ArrayList<Course> data = Courses.getInstance().getCourses();
    private final ScheduleForm scheduleForm = new ScheduleForm();
    private TreeSet<TimesInWeek> cacheSchedule = scheduleForm.getSchedule();
    private Course selected = null;
    private FunctionalInterfaces.OnDataChange onDataChange;

    public CourseForm() {
        editScheduleButton.addActionListener(e -> {
            JDialog dialog = new JDialog();
            dialog.setTitle("Schedule");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            scheduleForm.setSchedule(cacheSchedule, true);
            dialog.setContentPane(scheduleForm.getSchedulePanel());
            dialog.setBounds(400,300,700,200);
            dialog.setVisible(true);
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cacheSchedule = scheduleForm.getSchedule();
                }
            });
        });

        clearButton.addActionListener(e -> clearAllField());

        addButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            List<Integer> studentIDs = studentArea.getText().equals("") ? new ArrayList<>() :
                    Arrays.stream(studentArea.getText().split("\\s+")).map(Integer::parseInt).toList();
            new Course()
                    .setCourseName(nameField.getText())
                    .setStartDate(LocalDate.parse(startField.getText()))
                    .setFinishDate(LocalDate.parse(endField.getText()))
                    .setSchedule(cacheSchedule)
                    .setPrice(Long.parseLong(priceField.getText()))
                    .setTeacherID(Integer.parseInt(teacherField.getText()))
                    .setStudentIDs(new ArrayList<>(studentIDs));
            dataHasChanged();
        });

        editButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            List<Integer> studentIDs = studentArea.getText().equals("") ? new ArrayList<>() :
                    Arrays.stream(studentArea.getText().split("\\s+")).map(Integer::parseInt).toList();
            selected.setCourseName(nameField.getText())
                    .setStartDate(LocalDate.parse(startField.getText()))
                    .setFinishDate(LocalDate.parse(endField.getText()))
                    .setSchedule(cacheSchedule)
                    .setPrice(Long.parseLong(priceField.getText()))
                    .setTeacherID(Integer.parseInt(teacherField.getText()))
                    .setStudentIDs(new ArrayList<>(studentIDs));
            dataHasChanged();
        });

        deleteButton.addActionListener(e -> {
            Courses.getInstance().getCourses().removeIf
                    (course -> course.equals(selected));
            data.removeIf(course -> course.equals(selected));
            dataHasChanged();
        });

        findButton.addActionListener(e -> {
            checkFieldSilent();
            data = DataViewer.getCourses(course ->
                    DataChecker.isPartialMatch(searchName, course.getCourseName())
                    && DataChecker.isInBounds(course.getStartDate(), lowerStart, upperStart)
                    && DataChecker.isInBounds(course.getFinishDate(), lowerFinnish, upperFinish)
                    && DataChecker.isPerfectMatch(searchTeacher, course.getTeacherID())
                    && DataChecker.isInBounds(course.getPrice(), lowerPrice, upperPrice)
                    && DataChecker.isInBounds(course.getStudentIDs().size(), lowerStCount, upperStCount)
            );
            dataHasChanged();
            clearSearchResultButton.setEnabled(true);
        });

        clearSearchResultButton.addActionListener(e -> {
            data = Courses.getInstance().getCourses();
            dataHasChanged();
            DataChecker.clearTextInside(nameField, lowerFinnish, lowerPrice, lowerStart, lowerStCount,
                    upperStCount, upperStart, upperFinish, upperPrice, teacherField);
            clearSearchResultButton.setEnabled(false);
        });
    }

    public void sortByColumn(int col){
        Comparator<Course> comparator = null;
        // "Course Name", "Start Date", "Finish Date", "Teacher Name", "Student Count", "Schedule", "Price"
        switch (DataViewer.courseProps[col]){
            case "Course Name" -> comparator = Comparator.comparing(Course::getCourseName);
            case "Start Date" -> comparator = Comparator.comparing(Course::getStartDate);
            case "Finish Date" -> comparator = Comparator.comparing(Course::getFinishDate);
            case "Teacher Name" -> comparator = Comparator.comparingInt(Course::getTeacherID);
            case "Student Count" -> comparator = (o1, o2) -> {
                int s1 = o1.getStudentIDs().size();
                int s2 = o2.getStudentIDs().size();
                return s1 - s2;
            };
            case "Price" -> comparator = Comparator.comparingLong(Course::getPrice);
            case "Schedule" -> comparator = (o1, o2) -> 0;
        };
        data.sort(comparator);
        update();
    }

    private boolean checkFieldAlert(){
        return DataChecker.isNotEmpty(nameField, "Course Name Field")
                && DataChecker.isValidDate(startField, true)
                && DataChecker.isValidDate(endField, true)
                && DataChecker.isValidInt(teacherField, true)
                && DataChecker.isValidInt(priceField, true)
                && DataChecker.isListNumber(studentArea, "Student IDs");
    }

    private void checkFieldSilent(){
        DataChecker.isValidDate(lowerStart, false);
        DataChecker.isValidDate(upperStart, false);
        DataChecker.isValidDate(lowerFinnish, false);
        DataChecker.isValidDate(upperFinish, false);
        DataChecker.isValidInt(lowerPrice, false);
        DataChecker.isValidInt(upperPrice, false);
        DataChecker.isValidInt(lowerStCount, false);
        DataChecker.isValidInt(upperStCount, false);
        DataChecker.isValidInt(searchTeacher, false);
    }

    public void onTableCellSelected(int row, int col){
        selected = data.get(row);
        cacheSchedule = selected.getSchedule();
        if(DataViewer.courseProps[col].equals("Schedule")){
            JDialog dialog = new JDialog();
            dialog.setTitle("Schedule");
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            scheduleForm.setSchedule(cacheSchedule, false);
            dialog.setContentPane(scheduleForm.getSchedulePanel());
            dialog.setBounds(400,300,700,200);
            dialog.setVisible(true);
            return;
        }

        nameField.setText(selected.getCourseName());
        startField.setText(selected.getStartDate().toString());
        endField.setText(selected.getFinishDate().toString());
        teacherField.setText(selected.getTeacherID() + "");
        String temp = selected.getStudentIDs().stream().map(Object::toString)
                        .collect(Collectors.joining(" "));
        studentArea.setText(temp);
        priceField.setText(selected.getPrice() + "");

        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
        addButton.setEnabled(false);
    }

    private void clearAllField(){
        DataChecker.clearTextInside(nameField, startField, endField, teacherField, priceField);
        studentArea.setText("");
        cacheSchedule = new TreeSet<>();
        selected = null;

        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        addButton.setEnabled(true);
    }

    private void dataHasChanged(){
        update();
        clearAllField();
        DataWriter.saveAsXml(Courses.getInstance());
    }

    public void update(){
        onDataChange.updateData(
                DataViewer.courseToData(data),
                DataViewer.courseProps
        );
    }

    public JPanel getCourseInfoPanel() {
        return courseInfoPanel;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public void setOnDataChangeListener(FunctionalInterfaces.OnDataChange onDataChange) {
        this.onDataChange = onDataChange;
    }
}
