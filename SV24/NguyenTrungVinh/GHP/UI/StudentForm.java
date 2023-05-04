package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.*;
import SV24.NguyenTrungVinh.GHP.Obj.FunctionalInterfaces;
import SV24.NguyenTrungVinh.GHP.Obj.People;
import SV24.NguyenTrungVinh.GHP.Obj.Student;
import SV24.NguyenTrungVinh.GHP.XmlElement.Students;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class StudentForm {
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JPanel studentInfoPanel;
    private JButton deleteButton;
    private JButton editButton;
    private JButton clearButton;
    private JButton addButton;
    private JTextField lowID;
    private JTextField highID;
    private JTextField searchName;
    private JTextField lowAge;
    private JTextField highAge;
    private JTextField searchEmail;
    private JTextField searchAddress;
    private JButton clearSearchResultButton;
    private JButton findButton;
    private JTextField searchPhone;
    private JPanel studentSearchPanel;
    private FunctionalInterfaces.OnDataChange dataChangeListener;
    private ArrayList<Student> data = Students.getInstance().getStudents();
    private Student selected;
    public StudentForm() {
        addButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            new Student()
                    .setFullName(nameField.getText())
                    .setAge(Integer.parseInt(ageField.getText()))
                    .setPhoneNumber(phoneField.getText())
                    .setEmail(emailField.getText())
                    .setAddress(addressField.getText());
            dataHasChanged();
        });

        editButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            selected.setFullName(nameField.getText())
                    .setAge(Integer.parseInt(ageField.getText()))
                    .setPhoneNumber(phoneField.getText())
                    .setEmail(emailField.getText())
                    .setAddress(addressField.getText());
            dataHasChanged();
        });

        deleteButton.addActionListener(e -> {
            Students.getInstance().getStudents().removeIf
                    (student -> student.equals(selected));
            data.removeIf(student -> student.equals(selected));
            dataHasChanged();
        });

        clearButton.addActionListener(e -> clearAllField());

        findButton.addActionListener(e -> {
            checkFieldSilent();
            data = DataViewer.getStudents(s ->
                DataChecker.isInBounds(s.getId(), lowID, highID)
                    && DataChecker.isPartialMatch(searchName, s.getFullName())
                    && DataChecker.isInBounds(s.getAge(), lowAge, highAge)
                    && DataChecker.isPartialMatch(searchPhone, s.getPhoneNumber())
                    && DataChecker.isPartialMatch(searchEmail, s.getEmail())
                    && DataChecker.isPartialMatch(searchAddress, s.getAddress())
            );
            dataHasChanged();
            clearSearchResultButton.setEnabled(true);
        });

        clearSearchResultButton.addActionListener(e -> {
            DataChecker.clearTextInside(lowID, highID, lowAge, highAge, searchName, searchAddress, searchPhone, searchEmail);
            data = Students.getInstance().getStudents();
            dataHasChanged();
            clearSearchResultButton.setEnabled(false);
        });

    }

    public void sortByColumn(int col){
        Comparator<Student> comparator = null;
        // "ID", "Full Name", "Age", "Phone", "Email", "Address"
        switch (DataViewer.studentProps[col]){
            case "ID" -> comparator = Comparator.comparingInt(Student::getId);
            case "Full Name" -> comparator = Comparator.comparing(Student::getFullName);
            case "Age" -> comparator = Comparator.comparingInt(Student::getAge);
            case "Phone" -> comparator = Comparator.comparing(Student::getPhoneNumber);
            case "Email" -> comparator = Comparator.comparing(Student::getEmail);
            case "Address" -> comparator = Comparator.comparing(Student::getAddress);
        };
        data.sort(comparator);
        update();
    }

    private boolean checkFieldAlert(){
        return DataChecker.isValidInt(ageField, true)
                && DataChecker.isNotEmpty(nameField, "FullName Field")
                && DataChecker.isNotEmpty(phoneField, "Phone Field")
                && DataChecker.isNotEmpty(emailField, "Email Field")
                && DataChecker.isNotEmpty(addressField, "Address Field");
    }

    private void checkFieldSilent(){
        DataChecker.isValidInt(lowID, false);
        DataChecker.isValidInt(highID, false);
        DataChecker.isValidInt(lowAge, false);
        DataChecker.isValidInt(highAge, false);
    }

    private void clearAllField(){
        DataChecker.clearTextInside(idField, nameField, ageField, phoneField, emailField, addressField);

        deleteButton.setEnabled(false);
        editButton.setEnabled(false);
        addButton.setEnabled(true);
    }

    public void onTableCellSelected(int row, int col){
        deleteButton.setEnabled(true);
        editButton.setEnabled(true);
        addButton.setEnabled(false);

        selected = data.get(row);
        idField.setText(selected.getId() + "");
        nameField.setText(selected.getFullName());
        ageField.setText(selected.getAge() + "");
        phoneField.setText(selected.getPhoneNumber());
        emailField.setText(selected.getEmail());
        addressField.setText(selected.getAddress());
    }

    public void update(){
        dataChangeListener.updateData(
                DataViewer.studentsToData(data),
                DataViewer.studentProps
        );
    }

    private void dataHasChanged(){
        update();
        clearAllField();
        selected = null;
        DataWriter.saveAsXml(Students.getInstance());
    }

    public JPanel getStudentSearchPanel() {
        return studentSearchPanel;
    }

    public JPanel getStudentInfoPanel() {
        return studentInfoPanel;
    }
    public void setDataChangeListener(FunctionalInterfaces.OnDataChange dataChangeListener){
        this.dataChangeListener = dataChangeListener;
    }
}
