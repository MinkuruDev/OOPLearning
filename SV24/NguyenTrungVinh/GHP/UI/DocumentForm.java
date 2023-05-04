package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Data.DataChecker;
import SV24.NguyenTrungVinh.GHP.Data.DataViewer;
import SV24.NguyenTrungVinh.GHP.Data.DataWriter;
import SV24.NguyenTrungVinh.GHP.Obj.Course;
import SV24.NguyenTrungVinh.GHP.Obj.Document;
import SV24.NguyenTrungVinh.GHP.Obj.FunctionalInterfaces;
import SV24.NguyenTrungVinh.GHP.XmlElement.Documents;
import SV24.NguyenTrungVinh.GHP.XmlElement.Exams;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class DocumentForm {
    private JButton clearButton;
    private JButton deleteButton;
    private JButton editButton;
    private JButton addButton;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField publishField;
    private JTextField pageField;
    private JTextField priceField;
    private JButton clearSearchResultButton;
    private JButton findButton;
    private JTextField searchTitle;
    private JTextField searchAuthor;
    private JTextField lowerPublish;
    private JTextField upperPublish;
    private JTextField lowerPage;
    private JTextField upperPage;
    private JTextField lowerPrice;
    private JTextField upperPrice;
    private JPanel documentInfoPanel;
    private JPanel documentSearchPanel;

    private FunctionalInterfaces.OnDataChange onDataChangeListener;
    private ArrayList<Document> data = Documents.getInstance().getDocuments();
    private Document selected;

    public DocumentForm(){
        addButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;

            new Document()
                    .setTitle(titleField.getText())
                    .setAuthor(authorField.getText())
                    .setPublishYear(Integer.parseInt(publishField.getText()))
                    .setPageNumber(Integer.parseInt(pageField.getText()))
                    .setPrice(Long.parseLong(priceField.getText()));
            dataHasChanged();
        });

        editButton.addActionListener(e -> {
            if(! checkFieldAlert()) return;

            selected.setTitle(titleField.getText())
                    .setAuthor(authorField.getText())
                    .setPublishYear(Integer.parseInt(publishField.getText()))
                    .setPageNumber(Integer.parseInt(pageField.getText()))
                    .setPrice(Long.parseLong(priceField.getText()));
            dataHasChanged();
        });

        deleteButton.addActionListener(e -> {
            Documents.getInstance().getDocuments()
                    .removeIf(document -> document.equals(selected));
            data.removeIf(document -> document.equals(selected));
            dataHasChanged();
        });

        clearButton.addActionListener(e -> clearAllField());

        findButton.addActionListener(e -> {
            checkFieldSilent();
            data = DataViewer.getDocuments(document ->
                    DataChecker.isPartialMatch(searchTitle, document.getTitle())
                    && DataChecker.isPartialMatch(searchAuthor, document.getAuthor())
                    && DataChecker.isInBounds(document.getPublishYear(), lowerPublish, upperPublish)
                    && DataChecker.isInBounds(document.getPageNumber(), lowerPage, upperPage)
                    && DataChecker.isInBounds(document.getPrice(), lowerPrice, upperPrice)
            );
            dataHasChanged();
            clearSearchResultButton.setEnabled(true);
        });

        clearSearchResultButton.addActionListener(e -> {
            DataChecker.clearTextInside(searchTitle, searchAuthor, lowerPublish, upperPublish,
                    lowerPage, upperPage, lowerPrice, upperPrice);
            clearSearchResultButton.setEnabled(false);
            data = Documents.getInstance().getDocuments();
            dataHasChanged();
        });
    }

    public void sortByColumn(int col){
        Comparator<Document> comparator = null;
        // "Title", "Author", "Publish Year", "Page Number", "Price"
        switch (DataViewer.documentProps[col]){
            case "Title" -> comparator = Comparator.comparing(Document::getTitle);
            case "Author" -> comparator = Comparator.comparing(Document::getAuthor);
            case "Publish Year" -> comparator = Comparator.comparingInt(Document::getPublishYear);
            case "Page Number" -> comparator = Comparator.comparingInt(Document::getPageNumber);
            case "Price" -> comparator = Comparator.comparingLong(Document::getPrice);
        };
        data.sort(comparator);
        update();
    }

    private void dataHasChanged(){
        update();
        clearAllField();
        DataWriter.saveAsXml(Documents.getInstance());
    }

    private void clearAllField(){
        DataChecker.clearTextInside(titleField, authorField, pageField, publishField, priceField);
        selected = null;
        editButton.setEnabled(false);
        deleteButton.setEnabled(false);
        addButton.setEnabled(true);
    }

    public void onTableCellSelected(int row, int col){
        selected = data.get(row);
        editButton.setEnabled(true);
        deleteButton.setEnabled(true);
        addButton.setEnabled(false);

        titleField.setText(selected.getTitle());
        authorField.setText(selected.getAuthor());
        publishField.setText(selected.getPublishYear() + "");
        pageField.setText(selected.getPageNumber() + "");
        priceField.setText(selected.getPrice() + "");
    }

    private boolean checkFieldAlert(){
        return DataChecker.isNotEmpty(titleField, "Title Field")
                && DataChecker.isNotEmpty(authorField, "Title Field")
                && DataChecker.isValidInt(publishField, true)
                && DataChecker.isValidInt(pageField, true)
                && DataChecker.isValidInt(priceField, true);
    }

    private void checkFieldSilent(){
        DataChecker.isValidInt(lowerPublish, false);
        DataChecker.isValidInt(upperPublish, false);
        DataChecker.isValidInt(lowerPage, false);
        DataChecker.isValidInt(upperPage, false);
        DataChecker.isValidInt(lowerPrice, false);
        DataChecker.isValidInt(upperPrice, false);
    }

    public void update(){
        onDataChangeListener.updateData(
                DataViewer.documentToData(data),
                DataViewer.documentProps
        );
    }

    public JPanel getDocumentInfoPanel() {
        return documentInfoPanel;
    }

    public JPanel getDocumentSearchPanel() {
        return documentSearchPanel;
    }

    public void setOnDataChangeListener(FunctionalInterfaces.OnDataChange onDataChangeListener) {
        this.onDataChangeListener = onDataChangeListener;
    }
}
