/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package i.ogeyingbo.simplespring.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;

/**
 *
 * @author BOLAJI-OGEYINGBO
 */
public class JavaPdfExample {
    
    
    public  void  writePdfDocument(){
        
         Document document = new Document();
            try
            {
               PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
               document.open();
               document.add(new Paragraph("A Hello World PDF document."));
               document.close();
               writer.close();
            } catch (DocumentException e)
            {
               e.printStackTrace();
            } catch (FileNotFoundException e)
            {
               e.printStackTrace();
            }
      
    }
    
    
    
    
    public  void  setPdfFileAttributes(){
        
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("SetAttributeExample.pdf"));
            document.open();
            document.add(new Paragraph("Some content here"));

            //Set attributes here
            document.addAuthor("Lokesh Gupta");
            document.addCreationDate();
            document.addCreator("HowToDoInJava.com");
            document.addTitle("Set Attribute Example");
            document.addSubject("An example to show how attributes can be added to pdf files.");

            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    
    
    
    
    public  void  setImageOnPdf(){
        
        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("AddImageExample.pdf"));
            document.open();
            document.add(new Paragraph("Image Example"));

            //Add Image
            Image image1 = Image.getInstance("temp.jpg");

            //Fixed Positioning
            image1.setAbsolutePosition(100f, 550f);

            //Scale to new height and new width of image
            image1.scaleAbsolute(200, 200);

            //Add to document
            document.add(image1);

            String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
            Image image2 = Image.getInstance(new URL(imageUrl));
            document.add(image2);

            document.close();
            writer.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    
    
    
    
    
    
    
    
    
    
}
