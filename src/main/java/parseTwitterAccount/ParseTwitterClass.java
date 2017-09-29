package parseTwitterAccount;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.io.*;

import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.List;

public class ParseTwitterClass
{
    public static void oneHundredTweets() throws TwitterException, IOException
    {
        System.out.println("Please wait while programm creates file");

        File fileName = new File("src/results_twitter/twitter_result.xls");
        FileOutputStream fos = new FileOutputStream(fileName);
        HSSFWorkbook  workbook = new HSSFWorkbook();

        Sheet sheet = workbook.createSheet("nettuts");

        int num = 1;

        Row row = sheet.createRow(0);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue("Published Date");

        Cell cell1 = row.createCell(1);
        cell1.setCellValue("Message");

        for (int i = 0; i < 100; i++)
        {
            row = sheet.createRow(num);

            cell0 = row.createCell(0);
            cell0.setCellValue(String.valueOf(tweeterParser(i).getCreatedAt()));

            cell1 = row.createCell( 1);
            cell1.setCellValue(tweeterParser(i).getText());
            num += 1;
        }

        workbook.write(fos);
        fos.flush();
        fos.close();
        System.out.println("File twitter_result.xls created at src/results_twitter directory, at current project.");
    }

    private static Status tweeterParser(int tweet) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();

        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("AQ05bwI9GNuWsnW9ZUjKluQX6")
                .setOAuthConsumerSecret("CCRMICVD9CwBfG4EyXC9J0Mr4xypLyOGeozwpu0vKAvuIKHJDE")
                .setOAuthAccessToken("909131287239249920-rLUDP7wHBLctjD98kM3A0B8PWt1A1Wm")
                .setOAuthAccessTokenSecret("GvbwwjQKlrmS0Q5iq9gjZnT63711Hij1UXRq1AjXPYJoD");

        Twitter tf = new TwitterFactory(cb.build()).getInstance();
        //First param of Paging() is the page number, second is the number per page (this is capped around 200 I think.
        Paging paging = new Paging(1, 100);
        List<Status> statuses = tf.getUserTimeline("TutsPlusCode",paging);
        return statuses.get(tweet);
    }

}
