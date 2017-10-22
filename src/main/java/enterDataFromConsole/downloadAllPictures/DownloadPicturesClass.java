package enterDataFromConsole.downloadAllPictures;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DownloadPicturesClass
{
    public static void download() throws IOException
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter an url (for example https://www.hdwallpapers.in/ ): ");
        String webUrl = scan.nextLine();

        url_connection(webUrl);
    }

    public static void download_json() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader("src/main/java/runProgramFromJson/12th_task.json"));
        JSONObject jsonObject = (JSONObject)object;

        String url = (String) jsonObject.get("url");
        url_connection(url);
    }

    private static void url_connection(String url_string) throws IOException {
        URL url = new URL(url_string);
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        HTMLEditorKit htmlKit = new HTMLEditorKit();
        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
        HTMLEditorKit.Parser parser = new ParserDelegator();
        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
        parser.parse(br, callback, true);

        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next())
        {
            AttributeSet attributes = iterator.getAttributes();
            String imgSrc = (String) attributes.getAttribute(HTML.Attribute.SRC);

            if (imgSrc != null && (imgSrc.endsWith(".jpg") || (imgSrc.endsWith(".jpeg"))
                    || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".ico"))
                    || (imgSrc.endsWith(".bmp"))))
            {
                try {
                    downloadImage(url_string, imgSrc);
                }
                catch (IOException ex)
                {
                    System.out.println(ex.getMessage());
                }
            }
        }
        System.out.println("If program found images (.jpg, .png, .jpeg), they were downloaded to src/results_images directory. Please verify this folder at current project");
    }

    private static void downloadImage(String url, String imgSrc) throws IOException
    {
        BufferedImage image = null;
        try
        {
            if (!((imgSrc.startsWith("https"))||(imgSrc.startsWith("http"))))
            {
                url = url + imgSrc;
            } else {
                url = imgSrc;
            }
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = "src/results_images/" + imgSrc + "";
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null)
            {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
