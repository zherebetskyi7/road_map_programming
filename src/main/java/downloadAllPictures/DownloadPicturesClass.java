package downloadAllPictures;

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

        // Open connection with url
        URL url = new URL(webUrl);
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
                    downloadImage(webUrl, imgSrc);
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
