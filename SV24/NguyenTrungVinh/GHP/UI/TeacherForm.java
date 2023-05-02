package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.DataChecker;
import SV24.NguyenTrungVinh.GHP.Data.DataViewer;
import SV24.NguyenTrungVinh.GHP.Data.DataWriter;
import SV24.NguyenTrungVinh.GHP.Obj.FunctionalInterfaces;
import SV24.NguyenTrungVinh.GHP.Obj.Teacher;
import SV24.NguyenTrungVinh.GHP.XmlElement.Teachers;

import javax.swing.*;
import java.util.ArrayList;

public class TeacherForm {
    private JPanel teacherInfoPanel;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField phoneField;
    private JTextField emailField;
    private JTextField addressField;
    private JButton deleteButton;
    private JButton editButton;
    private JButton addButton;
    private JButton clearButton;
    private JPanel teacherSearchPanel;
    private JTextField lowID;
    private JTextField highID;
    private JTextField searchName;
    private JTextField lowAge;
    private JTextField highAge;
    private JTextField searchEmail;
    private JButton clearSearchResultButton;
    private JButton findButton;
    private JTextField searchAddress;
    private JTextField searchPhone;
    private JTextField salaryField;
    private JTextField lowSalary;
    private JTextField highSalary;
    private FunctionalInterfaces.OnDataChange dataChangeListener;
    private ArrayList<Teacher> data = Teachers.getInstance().getTeachers();
    private Teacher selected;

    public TeacherForm() {
        addButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            new Teacher()
                    .setSalary(Integer.parseInt(salaryField.getText()))
                    .setFullName(nameField.getText())
                    .setAge(Integer.parseInt(ageField.getText()))
                    .setPhoneNumber(phoneField.getText())
                    .setEmail(emailField.getText())
                    .setAddress(addressField.getText());
            dataHasChanged();
        });

        editButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;
            selected.setSalary(Integer.parseInt(salaryField.getText()))
                    .setFullName(nameField.getText())
                    .setAge(Integer.parseInt(ageField.getText()))
                    .setPhoneNumber(phoneField.getText())
                    .setEmail(emailField.getText())
                    .setAddress(addressField.getText());
            dataHasChanged();
        });

        deleteButton.addActionListener(e -> {
            Teachers.getInstance().getTeachers().removeIf
                    (teacher -> teacher.equals(selected));
            data.removeIf(teacher -> teacher.equals(selected));
            dataHasChanged();
        });

        clearButton.addActionListener(e -> clearAllField());

        findButton.addActionListener(e -> {
            checkFieldSilent();
            data = DataViewer.getTeachers(t ->
                    DataChecker.isInBounds(t.getId(), lowID, highID)
                            && DataChecker.isPartialMatch(searchName, t.getFullName())
                            && DataChecker.isInBounds(t.getAge(), lowAge, highAge)
                            && DataChecker.isPartialMatch(searchPhone, t.getPhoneNumber())
                            && DataChecker.isPartialMatch(searchEmail, t.getEmail())
                            && DataChecker.isPartialMatch(searchAddress, t.getAddress())
                            && DataChecker.isInBounds(t.getSalary(), lowSalary, highSalary)
            );
            dataHasChanged();
            clearSearchResultButton.setEnabled(true);
        });

        clearSearchResultButton.addActionListener(e -> {
            DataChecker.clearTextInside(lowID, highID, lowAge, highAge, searchName, searchAddress, searchPhone, searchEmail);
            data = Teachers.getInstance().getTeachers();
            dataHasChanged();
            clearSearchResultButton.setEnabled(false);
        });

    }

    private boolean checkFieldAlert(){
        return DataChecker.isValidInt(ageField, true)
                && DataChecker.isNotEmpty(nameField, "FullName Field")
                && DataChecker.isNotEmpty(phoneField, "Phone Field")
                && DataChecker.isNotEmpty(emailField, "Email Field")
                && DataChecker.isNotEmpty(addressField, "Address Field")
                && DataChecker.isValidInt(salaryField, true);
    }

    private void checkFieldSilent(){
        DataChecker.isValidInt(lowID, false);
        DataChecker.isValidInt(highID, false);
        DataChecker.isValidInt(lowAge, false);
        DataChecker.isValidInt(highAge, false);
        DataChecker.isValidInt(lowSalary, false);
        DataChecker.isValidInt(highSalary, false);
    }

    private void clearAllField(){
        DataChecker.clearTextInside(idField, nameField, ageField, phoneField, emailField, addressField, salaryField);

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
        salaryField.setText(selected.getSalary() + "");
    }

    public void update(){
        dataChangeListener.updateData(
                DataViewer.teacherToData(data),
                DataViewer.teacherProps
        );
    }

    private void dataHasChanged(){
        update();
        clearAllField();
        selected = null;
        DataWriter.saveAsXml(Teachers.getInstance());
    }

    public JPanel getTeacherInfoPanel() {
        return teacherInfoPanel;
    }

    public JPanel getTeacherSearchPanel() {
        return teacherSearchPanel;
    }

    public void setDataChangeListener(FunctionalInterfaces.OnDataChange dataChangeListener){
        this.dataChangeListener = dataChangeListener;
    }
}
