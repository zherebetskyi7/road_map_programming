package enterDataFromConsole.htmlConvertToPdf;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import org.jdom.JDOMException;


import java.util.Scanner;

import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HttpDownloadUtility
{

    public static void download() throws Exception {
        remove_files_from_directory();

        System.out.println("Please enter a url (for example https://stackoverflow.com/):");

        Scanner scan = new Scanner(System.in);
        String string_url = scan.nextLine();

        pdf_creation_function(string_url);
    }

    public static void download_json() throws Exception {
        remove_files_from_directory();

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/13th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String webUrl = (String) jsonObject.get("url");
        pdf_creation_function(webUrl);
    }

    private static void pdf_creation_function(String webUrl) throws Exception {
        URL url = new URL(webUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/results_pdf/data.html"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        reader.close();
        writer.close();

        //----------------------- HTML TO XML CREATTION ------------------------
        FileWriter fwOutXml = null;
        FileReader frInHtml = null;
        BufferedWriter bwOutXml = null;
        BufferedReader brInHtml = null;

        frInHtml = new FileReader("src/results_pdf/data.html");
        brInHtml = new BufferedReader(frInHtml);
        SAXBuilder saxBuilder = new SAXBuilder("org.ccil.cowan.tagsoup.Parser", false);
        org.jdom.Document jdomDocument = saxBuilder.build(brInHtml);
        XMLOutputter outputter = new XMLOutputter();

        outputter.output(jdomDocument, System.out);
        fwOutXml = new FileWriter("src/results_pdf/temp_xml.xml");
        bwOutXml = new BufferedWriter(fwOutXml);
        outputter.output(jdomDocument, bwOutXml);
        System.out.flush();
        System.out.println("XML Creation Done");

        fwOutXml.flush();
        fwOutXml.close();
        bwOutXml.close();
        //----------------------- HTML TO XML CREATTION ------------------------

        //----------------------- XML TO PDF CREATTION ------------------------
        Document document = new Document();
        PdfWriter writer2 = PdfWriter.getInstance(document, new FileOutputStream("src/results_pdf/pdf.pdf"));
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer2, document, new FileInputStream("src/results_pdf/temp_xml.xml"));
        document.close();
        System.out.println("PDF Created Successfully");
        //----------------------- XML TO PDF CREATTION ------------------------

        File html_temp_file = new File("src/results_pdf/data.html");
        File xml_temp_file = new File("src/results_pdf/temp_xml.xml");
        xml_temp_file.delete();
        html_temp_file.delete();
        System.out.println("Please check PDF file in src/results_pdf");
    }

    private static void remove_files_from_directory()
    {
        File file = new File("src/results_pdf");
        String[] myFiles;
        if(file.isDirectory()){
            myFiles = file.list();
            for (int i=0; i<myFiles.length; i++) {
                File myFile = new File(file, myFiles[i]);
                myFile.delete();
            }
        }
    }
}
