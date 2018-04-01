package parser.converters;

import parser.model.Metall;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URL;

public class MetallConverter {

    public static void marshallMetall(Metall metall) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Metall.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(metall, System.out);
    }

    public static Metall unmarshallMetall(URL url) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Metall.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object o = unmarshaller.unmarshal(url);

        Metall metall = (Metall) o;
        return (Metall) o;
    }

    public static Metall unmarshallMetall(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Metall.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object o = unmarshaller.unmarshal(file);

        return (Metall) o;
    }
}
