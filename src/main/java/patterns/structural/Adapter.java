pacakge patterns.structural;
/*
Adapter is a structural design pattern which acts as connecter between two incompatible interfaces.
Example:
Upstream sends the data in flat file format.
We convert the data into JSON format and pass it to subsystem using Adapter pattern.
*/
interface XMLReader {
  public String readXML(File file);
}
class XMLReaderImpl implements XMLReader {
  public String readXML(File file) {
    //read file
    //convert it to xml
    return "<xml/>";
  }
}

interface XMLReaderAdapter {
  public String readXML(File file);
}
class XMLReaderAdapterImpl implements XMLReaderAdapter {
  private XMLReader xmlReader;
  public XMLReaderAdapterImpl(XMLReader xmlReader) {
    this.xmlReader = xmlReader;
  }
  public String readXML(File file) {
    String xml = xmlReader.readXML(file);
    String json = xmlToJsonConverter(xml);
  }
  
  private String xmlToJsonConverter(String xml) {
    //process xml and convert it to JSON
    return "{}";
  }
}

public class Adapter {
  public static void main(String[] args) {
    XMLReader xmlReader = new XMLReaderImpl();
    XMLReaderAdapter adapter = new XMLReaderAdapterImpl(xmlReader);
    String json = adapter.readXML(new File("abc.txt"));
  }
}
