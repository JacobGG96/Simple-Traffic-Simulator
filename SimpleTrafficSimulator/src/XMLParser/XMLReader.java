package XMLParser;

import Listas.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;         // |
import org.jdom2.Element;          // |\ Librerías
import org.jdom2.JDOMException;    // |/ JDOM
import org.jdom2.input.SAXBuilder;

@SuppressWarnings({ "rawtypes", "unchecked" })

public class XMLReader {
	
    public int tamañolista;
    public int tamañotramo;
    public int tamañosubtramo;
    GenericListHw Highway1 = new GenericListHw();
	GenericListSS Subsection1 = new GenericListSS();
    GenericListSec section1 = new GenericListSec();
 
	
    //Se crea un SAXBuilder para poder parsear el archivo
    SAXBuilder builder = new SAXBuilder();
    File xmlFile = new File( "src/XMLParser/Carreteras.xml" );  

    
    public GenericListHw<GenericListHw> cargarXML(){
    
        try{
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build(xmlFile);
               
            //Se obtiene la raiz 'carreteras'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'carreteras'
            tamañolista = rootNode.getChildren( "carretera" ).size();
            System.out.println("La cantidad de carreteras es: " + tamañolista + "\n");
            
            //Se recorre la lista de hijos de 'carreteras'
            for ( int i = 0; i < tamañolista; i++ ){
                //Se obtiene el elemento 'carretera'
            	
            	Element a = rootNode.getChildren().get(i);
                //Se obtiene el atributo 'nombre' que esta en el tag 'carretera'
                String _idhw = a.getAttributeValue("id");
                String _distancia = a.getAttributeValue("distancia");
                String _sentido = a.getAttributeValue("sentido");
                getsectiondata(a);
                Highway1.insertarAlFrente(_idhw, _distancia, _sentido, section1);
               }
            
        }

        catch(IOException | JDOMException io ) {
            System.out.println( io.getMessage() );
        }
        System.out.println(Highway1);
		return Highway1;
        
        
        
    
    }

	private void getsectiondata(Element a) {		
            //Se obtiene el elemento 'carretera'
        	Element b = a.getChildren().get(0);
        	getdatasectionlist(b);
    }
	private void getdatasectionlist(Element b){
		for(int i = 0; i <= b.getChildren().size(); i++ ){
		// TODO Auto-generated method stub
			Element c =  b.getChildren().get(i);
			String _idsec =  c.getAttributeValue("id");
			String _direccion= c.getAttributeValue("direccion");
			String _radio = c.getAttributeValue("radio");
			String _posXi = c.getAttributeValue("PosXi");
			String _posYi = c.getAttributeValue("PosYi");
			String _posXf = c.getAttributeValue("PosXf");
			String _posYf = c.getAttributeValue("PosYf");
			String _distancia = c.getAttributeValue("Distancia");
			getsubsectiondata(c);
			section1.insertarAlFrente(_idsec,_direccion, _radio, Subsection1, _posXi, _posYi, _posXf, _posYf, _distancia);
			}
		}
	private void getsubsectiondata(Element c){
		for(int i = 0 ; i <= c.getChildren().size(); i++ ){
			Element d = c.getChildren().get(i);
			getdatasubsectionlist(c);
		}
	}


	private void getdatasubsectionlist(Element c) {
		for(int i = 0; i <= c.getChildren().size(); i++ ){
			Element d =  c.getChildren().get(i);
			// TODO Auto-generated method stub
			String _idss = d.getAttributeValue("id");
			String _velocidad =  d.getAttributeValue("velocidad");
			String _inclinacion = d.getAttributeValue("inclinacion");
			String _cantcarri = d.getAttributeValue("CantCarri");
			String _distancia = d.getAttributeValue("Distancia");
			Subsection1.insertarAlFrente( _idss, _velocidad, _inclinacion, _cantcarri, _distancia);

			}
	}
}