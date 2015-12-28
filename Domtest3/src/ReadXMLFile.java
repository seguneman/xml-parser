import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXMLFile {
 
 public static void main(String argv[]) {
 
   try {
 
  File fXmlFile = new File("C:\\Users\\chopin\\workspace\\DomTest1\\src\\police1.xml");
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  Document doc = dBuilder.parse(fXmlFile);
  doc.getDocumentElement().normalize();
 
  System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
  NodeList nList = doc.getElementsByTagName("company");

  System.out.println("-----------------------");
 
  for (int temp = 0; temp < nList.getLength(); temp++) {
	 
	  Node nNode = nList.item(temp);
		
     if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    	 
        Element eElement = (Element) nNode;
      //  System.out.println("company : " + getTagValue("company", eElement));
        System.out.println("platoon : " + getTagValue("platoon", eElement));
        System.out.println("squad : " + getTagValue("squad", eElement));
               System.out.println("Name : " + getTagValue("Name", eElement));
        System.out.println("age : " + getTagValue("age", eElement));
        System.out.println("Height : " + getTagValue("Height", eElement)+"cm");
        System.out.println("Weight : " + getTagValue("Weight", eElement)+"kg");
        System.out.println("Class : " + getTagValue("Class", eElement));
        System.out.println("retire Date : " + getTagValue("Date", eElement));
 
     }
  	}
  
   } catch (Exception e) {
  e.printStackTrace();
   }
  }
 
  private static String getTagValue(String sTag, Element eElement) {
 NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
 
        Node nValue = (Node) nlList.item(0);
 
 return nValue.getNodeValue();
  }
 
}