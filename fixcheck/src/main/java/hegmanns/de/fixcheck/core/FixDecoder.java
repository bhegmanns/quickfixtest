package hegmanns.de.fixcheck.core;

import java.io.IOException;
import java.io.StringBufferInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import quickfix.FieldNotFound;
import quickfix.InvalidMessage;
import quickfix.Message;
import quickfix.MessageUtils;
import quickfix.ScreenLog;
import quickfix.Message.Header;
import quickfix.Message.Trailer;

public class FixDecoder extends AbstractFix{
	
	public FixDecoder(String xmlDefinition){
		super(xmlDefinition, true);
	}
	
	public FixDecoder(FixSpecification fixSpecification){
		this(fixSpecification.getXmlDatadictionaryFile());
	}
	
	public Message parseFixMessage(String messageString){
		return parseFixMessage(messageString, false);
	}
	
	public Message parseFixMessage(String messageString, boolean validation){
		Message message = new Message();
		try {
			message.fromString(messageString, getDataDictionary(), validation);
		} catch (InvalidMessage e) {
			throw new RuntimeException("invalid Message:", e);
		}
		
		return message;
	}
	
	public void print(Message message) {
		if (message == null){throw new RuntimeException("message is null");}
		
		StringBufferInputStream sbis = new StringBufferInputStream(message.toXML());
		System.out.println(message.toXML());
//		System.out.println("" + getDataDictionary().getFieldName(56));
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(sbis);
		Element documentElement = document.getDocumentElement();
		System.out.println("" + documentElement.getTagName());
		NodeList childNodes = documentElement.getChildNodes();
		System.out.println("childs: " + childNodes.getLength());
		for (int i = 0 ; i< childNodes.getLength() ; i++){
			if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE)
			{
				if (childNodes.item(i).hasAttributes()){
				}
			}
//			System.out.println("" + childNodes.item(i).getNodeName());
		}
//		System.out.println("" + firstChild.getNodeName());
		}catch(Exception e){throw new RuntimeException(e);}
//		ScreenLog l = ScreenLog
//		MessageUtils.
		
//		int[] fieldOrder = message.getFieldOrder();
		int[] fieldOrder = null;
//		Header header = message.getHeader();
//		fieldOrder = header.getFieldOrder();
//		for (int tagnumber : fieldOrder){
//			String s = null;
//			try {
//				s = message.getString(tagnumber);
//				System.out.println("" + tagnumber + "(" + getDataDictionary().getFieldName(tagnumber) + "): " + s);
//			} catch (FieldNotFound e) {
		
//			}
//		}
		
//		Trailer trailer = message.getTrailer();
//		
//		fieldOrder = getDataDictionary().getOrderedFields();
//		for (int tagnumber : fieldOrder){
//			String s = null;
//			try {
//				s = message.getString(tagnumber);
//				System.out.println("" + tagnumber + "(" + getDataDictionary().getFieldName(tagnumber) + "): " + s);
//			} catch (FieldNotFound e) {
//				System.out.println("" + tagnumber);
//			}
//		}
	}
}
