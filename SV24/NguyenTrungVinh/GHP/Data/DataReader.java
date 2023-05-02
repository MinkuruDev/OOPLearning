package SV24.NguyenTrungVinh.GHP.Data;

import SV24.NguyenTrungVinh.GHP.XmlElement.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class DataReader {
    public static void readAll(){
        Students.init((Students) readXMLFile("Data/student.xml", Students.class));
        Exams.init((Exams) readXMLFile("Data/exam.xml", Exams.class));
        Teachers.init((Teachers) readXMLFile("Data/teacher.xml", Teachers.class));
        Courses.init((Courses) readXMLFile("Data/course.xml", Courses.class));
        Documents.init((Documents) readXMLFile("Data/document.xml", Documents.class));
    }

    public static Object readXMLFile(String fileName, Class<?> clazz) {
        try {
            File xmlFile = new File(fileName);
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            return jaxbUnmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
