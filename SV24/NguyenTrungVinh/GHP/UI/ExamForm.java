package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.DataChecker;
import SV24.NguyenTrungVinh.GHP.Data.DataViewer;
import SV24.NguyenTrungVinh.GHP.Data.DataWriter;
import SV24.NguyenTrungVinh.GHP.Obj.Course;
import SV24.NguyenTrungVinh.GHP.Obj.Exam;
import SV24.NguyenTrungVinh.GHP.Obj.FunctionalInterfaces;
import SV24.NguyenTrungVinh.GHP.XmlElement.Exams;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class ExamForm {
    private JTextField nameField;
    private JTextField certificateField;
    private JTextField dateField;
    private JTextField timeField;
    private JTextField durationField;
    private JPanel examInfoPanel;
    private JButton clearButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton addButton;
    private JPanel examSearchPanel;
    private JTextField searchName;
    private JTextField searchCert;
    private JTextField lowerDate;
    private JTextField upperDate;
    private JTextField upperDuration;
    private JButton clearSearchResultButton;
    private JButton findButton;
    private JTextField lowerDuration;
    private JTextField priceField;
    private JTextField lowerPrice;
    private JTextField upperPrice;
    private ArrayList<Exam> data = Exams.getInstance().getExams();
    private FunctionalInterfaces.OnDataChange onDataChangeListener;
    private Exam selected;

    public ExamForm(){
        addButton.addActionListener(e -> {
            if(!checkFieldAlert()) return;
            new Exam()
                    .setExamName(nameField.getText())
                    .setCertificateName(certificateField.getText())
                    .setExamDateTime(LocalDateTime.of(
                            LocalDate.parse(dateField.getText()),
                            LocalTime.parse(timeField.getText())))
                    .setDurationInMinutes(Integer.parseInt(durationField.getText()))
                    .setPrice(Long.parseLong(priceField.getText()));
            dataHasChanged();
        });

        editButton.addActionListener(e -> {
            if(!checkFieldAlert()) return;
            selected.setExamName(nameField.getText())
                    .setCertificateName(certificateField.getText())
                    .setExamDateTime(LocalDateTime.of(
                            LocalDate.parse(dateField.getText()),
                            LocalTime.parse(timeField.getText())))
                    .setDurationInMinutes(Integer.parseInt(durationField.getText()))
                    .setPrice(Long.parseLong(priceField.getText()));
            dataHasChanged();
        });

        clearButton.addActionListener(e -> clearAllField());

        deleteButton.addActionListener(e -> {
            Exams.getInstance().getExams()
                    .removeIf(exam -> exam.equals(selected));
            data.removeIf(exam -> exam.equals(selected));
            dataHasChanged();
        });

        findButton.addActionListener(e -> {
            checkFieldSilent();
            data = DataViewer.getExams(exam ->
                    DataChecker.isPartialMatch(searchName, exam.getExamName())
                    && DataChecker.isPartialMatch(searchCert, exam.getCertificateName())
                    && DataChecker.isInBounds(exam.getExamDateTime().toLocalDate(), lowerDate, upperDate)
                    && DataChecker.isInBounds(exam.getDurationInMinutes(), lowerDuration, upperDuration)
                    && DataChecker.isInBounds(exam.getPrice(), lowerPrice, upperPrice)
            );
            dataHasChanged();
            clearSearchResultButton.setEnabled(true);
        });

        clearSearchResultButton.addActionListener(e -> {
            data = Exams.getInstance().getExams();
            dataHasChanged();
            clearSearchResultButton.setEnabled(false);
            DataChecker.clearTextInside(searchName, searchCert, lowerDate, lowerDuration,
                    upperDate, upperDuration, lowerPrice, upperPrice);
        });
    }

    public void sortByColumn(int col){
        Comparator<Exam> comparator = null;
        // "Exam Name", "Certificate Name", "Exam Time", "Duration (minutes)", "Price"
        switch (DataViewer.examProps[col]){
            case "Exam Name" -> comparator = Comparator.comparing(Exam::getExamName);
            case "Certificate Name" -> comparator = Comparator.comparing(Exam::getCertificateName);
            case "Exam Time" -> comparator = Comparator.comparing(Exam::getExamDateTime);
            case "Duration (minutes)" -> comparator = Comparator.comparingInt(Exam::getDurationInMinutes);
            case "Price" -> comparator = Comparator.comparingLong(Exam::getPrice);
        };
        data.sort(comparator);
        update();
    }

    private boolean checkFieldAlert(){
        return DataChecker.isNotEmpty(nameField, "Exam Name Field")
                && DataChecker.isNotEmpty(certificateField, "Certificate Field")
                && DataChecker.isValidDate(dateField, true)
                && DataChecker.isValidTime(timeField, true)
                && DataChecker.isValidInt(durationField, true);
    }

    private void checkFieldSilent(){
        DataChecker.isValidDate(upperDate, false);
        DataChecker.isValidDate(lowerDate, false);
        DataChecker.isValidInt(lowerDuration, false);
        DataChecker.isValidInt(upperDuration, false);
        DataChecker.isValidInt(lowerPrice, false);
        DataChecker.isValidInt(upperPrice, false);
    }

    public JPanel getExamInfoPanel() {
        return examInfoPanel;
    }

    public JPanel getExamSearchPanel() {
        return examSearchPanel;
    }

    public void update(){
        onDataChangeListener.updateData(
                DataViewer.examToData(data),
                DataViewer.examProps
        );
    }

    private void dataHasChanged(){
        update();
        clearAllField();
        selected = null;
        DataWriter.saveAsXml(Exams.getInstance());
    }

    private void clearAllField(){
        DataChecker.clearTextInside(nameField, certificateField, dateField, timeField, durationField, priceField);

        addButton.setEnabled(true);
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }

    public void onTableCellSelected(int row, int col){
        selected = data.get(row);

        nameField.setText(selected.getExamName());
        certificateField.setText(selected.getCertificateName());
        dateField.setText(selected.getExamDateTime().toLocalDate().toString());
        timeField.setText(selected.getExamDateTime().toLocalTime().toString());
        durationField.setText(selected.getDurationInMinutes() + "");
        priceField.setText(selected.getPrice() + "");

        addButton.setEnabled(false);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
    }

    public void setOnDataChangeListener(FunctionalInterfaces.OnDataChange onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }
}
