package org.example;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.MimeConstants;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ConvertToPDF {
    public static void main(String[] args) {
        try {
            File xsltFile = new File("src/main/resources/books.xsl");
            StreamSource xmlSource = new StreamSource(new File("src/main/resources/books.xml"));
            File pdfFile = new File("books.pdf");

            FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

            OutputStream out = new FileOutputStream(pdfFile);
            out = new java.io.BufferedOutputStream(out);

            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            SAXResult res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(xmlSource, res);

            out.close();

            System.out.println("PDF file created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
