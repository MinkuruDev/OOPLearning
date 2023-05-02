package SV24.NguyenTrungVinh.GHP.XmlElement;

import SV24.NguyenTrungVinh.GHP.Obj.Document;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;

@XmlRootElement
public class Documents implements Serializable {
    @XmlElement(name = "document")
    private final ArrayList<Document> documents;
    private static Documents instance = new Documents();

    public static void init(Documents documents){
        if(documents != null)
            instance = documents;
    }
    private Documents(){
        documents = new ArrayList<>();
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public static Documents getInstance() {
        return instance;
    }

    public static void addDocument(Document document){
        instance.documents.add(document);
    }
}
