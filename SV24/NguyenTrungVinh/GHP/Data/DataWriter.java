package SV24.NguyenTrungVinh.GHP.Data;

import SV24.NguyenTrungVinh.GHP.XmlElement.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class DataWriter {
    public static void writeAll(){
        saveAsXml(Students.getInstance());
        saveAsXml(Teachers.getInstance());
        saveAsXml(Courses.getInstance());
        saveAsXml(Exams.getInstance());
        saveAsXml(Documents.getInstance());
    }

    public static String serializableToXmlString(Serializable serializable) {
        try{
            JAXBContext jaxbContext = JAXBContext.newInstance(serializable.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter stringWriter = new StringWriter();
            marshaller.marshal(serializable, stringWriter);

            return stringWriter.toString();
        }catch (JAXBException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void saveAsXml(Serializable serializable) {
        String filepath = "Data/";
        if(serializable instanceof Students)
            filepath += "student.xml";
        else if (serializable instanceof Teachers)
            filepath += "teacher.xml";
        else if (serializable instanceof Courses)
            filepath += "course.xml";
        else if (serializable instanceof Documents)
            filepath += "document.xml";
        else if(serializable instanceof Exams)
            filepath += "exam.xml";
        else
            filepath += "unknown.xml";

        try {
            File file = new File(filepath);
            file.createNewFile();

            FileWriter writer = new FileWriter(filepath);
            writer.write(serializableToXmlString(serializable));
            writer.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

    }


}
