package crawlercalenderprogram;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlerCalenderProgram {

    public static void main(String[] args) throws IOException,
        InterruptedException {

        String html = "https://market.aotter.net/item/16"
            + "26/aotter-girls電獺少女2020桌曆掛曆限定紀念版開催中";
        while (true) {
            Document doc = Jsoup.connect(html)
                .userAgent("Mozilla/5.0 (Windows; U; WindowsNT 5.1; en-US; rv1.8.1.6) Gecko/20070725 Firefox/2.0.0.6")
                .referrer("http://www.google.com")
                .get();
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("資料爬取時間: " + formatter.format(date));
            System.out.println(doc.title());
            System.out.println("販售組合:");
            Elements NormalCalendar = doc.select("body > div.container > "
                + "div.template > div > div.container > div > div.col-md-4 > aside"
                + " > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)");
            System.out.print("|");
            for (Element content : NormalCalendar) {
                System.out.println(content.text());
            }
            Elements NormalCalendarAmount = doc.select("body > div.container >"
                + " div.template > div > div.container > div > div.col-md-4 > aside >"
                + " div:nth-child(2) > div:nth-child(2) > div.sk-num.center");
            System.out.print("|");
            for (Element content : NormalCalendarAmount) {
                System.out.println(content.text());
            }
            System.out.println("==================================");
            Elements SuperCollection = doc.select("body > div.container > "
                + "div.template > div > div.container > div > div.col-md-4 > aside "
                + "> div:nth-child(2) > div:nth-child(3) > div:nth-child(1)");
            System.out.print("|");
            for (Element content : SuperCollection) {
                System.out.println(content.text());
            }
            Elements SuperCollectionAmount = doc.select("body > div.container > "
                + "div.template > div > div.container > div > div.col-md-4 > aside > "
                + "div:nth-child(2) > div:nth-child(3) > div.sk-num.center");
            System.out.print("|");
            for (Element content : SuperCollectionAmount) {
                System.out.println(content.text());
            }
            System.out.println("==================================");
            Elements BigCalendar = doc.select("body > div.container >"
                + " div.template > div > div.container > div > div.col-md-4 > aside >"
                + " div:nth-child(2) > div:nth-child(4) > div:nth-child(1)");
            System.out.print("|");
            for (Element content : BigCalendar) {
                System.out.println(content.text());
            }
            Elements BigCalendarAmount = doc.select("body > div.container > "
                + "div.template > div > div.container > div > div.col-md-4 > aside "
                + "> div:nth-child(2) > div:nth-child(4) > div.sk-num.center");
            System.out.print("|");
            for (Element content : BigCalendarAmount) {
                System.out.println(content.text());
            }
            System.out.println("==================================\n\n");
            System.gc();
            Thread.sleep(10000);
        }
    }
}
