import java.io.File;  
import java.io.StringWriter;  
  
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.BeanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;  
  
  
  
/* 
 * DOM Class Great 
 *  
 */  
public class Creat_XML {  
  public static void main(String [] ags){  
        
     try {  
           
     DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();  
     DocumentBuilder builder = factory.newDocumentBuilder();  
           
         Document document = builder.newDocument();   
     //创建属性名、赋值  
         Element root = document.createElement("Languages");
         root.setAttribute("cat", "it");  
  
                 //创建第一个根节点、赋值  
         Element lan = document.createElement("lan");  
         lan.setAttribute("id", "1");  
         Element name = document.createElement("name");  
         name.setTextContent("java");  
         Element ide = document.createElement("IDE");  
         ide.setTextContent("Eclipse");  
         lan.appendChild(name);  
         lan.appendChild(ide);              //创建第二个根节点、赋值
         Element lan2 = document.createElement("lan");  
         lan2.setAttribute("id", "2");  
         Element name2 = document.createElement("name");  
         name2.setTextContent("Swift");  
         Element ide2 = document.createElement("ide");  
         ide2.setTextContent("XCode");  
         lan2.appendChild(name2);  
         lan2.appendChild(ide2);  
           
                 //添加到属性中、  
         root.appendChild(lan);  
                 root.appendChild(lan2);      
                 document.appendChild(root);  
           
                //定义了用于处理转换指令，以及执行从源到结果的转换的  
        TransformerFactory transformerFactory = TransformerFactory.newInstance();  
        Transformer transformer = transformerFactory.newTransformer();  
        transformer.setOutputProperty("encoding", "UTF-8");  
              
        StringWriter writer = new StringWriter();  
        transformer.transform(new DOMSource(document), new StreamResult(writer));  
        System.out.println(writer.toString());  
              
        transformer.transform(new DOMSource(document), new StreamResult(new File("newxml.xml")));



          
          
    } catch (ParserConfigurationException | TransformerException e) {  
        e.printStackTrace();  
    }  
  }  
}  