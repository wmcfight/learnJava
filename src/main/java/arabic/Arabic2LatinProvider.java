package arabic;

import com.google.common.io.Resources;
import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Translate Arabic to Latin,
 * This class just provides a solution to translate Arabic text per character to latin character.
 *
 */
public class Arabic2LatinProvider {
    private Logger logger = Logger.getLogger(getClass());

    public static String transliterate(String sourceContent) {
        if (StringUtils.isBlank(sourceContent)) {
            return sourceContent;
        }

        String transliteratingData = sourceContent;
        String data = transliterateByPerChar(transliterateByChars(transliteratingData));
        return StringUtils.trim(data);
    }

    private static String transliterateByPerChar(String sourceContent) {
        final StringBuffer finalConverterResultBuffer = new StringBuffer();
        for (int i = 0; i < sourceContent.length(); i++) {
            finalConverterResultBuffer.append(ArabicCharacterUtils.convertCharToLatin(sourceContent.charAt(i)));
        }
        return finalConverterResultBuffer.toString();
    }

    private static String transliterateByChars(final String sourceContent) {
        String convertingData = sourceContent;
        for (Map.Entry<String, String> entry : inputData.entrySet()) {
            convertingData = StringUtils.replace(convertingData, entry.getKey(), entry.getValue());
            System.out.println(convertingData);
        }
        return convertingData;
    }

    private static List<String> data = new ArrayList<String>()
    {
        {
            add("شارع الامير مشعل بن عبدالعزيز");
            add("شارع الستين");
            add("شارع الستين");
            add("الإذاعة");
            add("الأمير مشعل بن عبدالعزيز");
            add("الرحمانية 3");
            add("الإذاعة");
            add("شارع المكرونة");
            add("شارع المفروشات");
            add("شارع المكرونة");
            add("طريق الأمير محمد بن عبد العزيز");
            add("جده شارع الامير ماجد السبعين فلامنجو مول الشياكه");
            add("طريق الأمير محمد بن عبد العزيز");
            add("كومامبو شارع صلاح سالم بجوار صيدلية مكرم");
            add("الرياض /الناصريه  شارع /المعذر /بجوار شركه الكهرباء");
            add("كومامبو الالبان عمارة خير لمعى شحاتة بجوار المسجد");
            add("القصيم بريدة حي الامن مقابل الستاد الرياضي");
            add("الرياض .الروضه.تقاطع شارع الأمير بندر مع عبد الرحمن الناصر");
            add("الرياض .الروضه.تقاطع شارع الأمير بندر مع عبد الرحمن الناصر");
            add("الرحمانية 3");
            add("الصناعيه الجديد");
            add("الصناعيه الجديد");
            add("قرية شرما");
            add("الصناعيه الثانيه طريق ابقيق شركه هلا");
            add("قرية شرما");
            add("حي الضباب مقابل الجبل الاخضر");
            add("حي الضباب مقابل الجبل الاخضر");
            add("الادهم");
            add("اخر الخنساء مقابل عطار البحرين");
            add("بلديه الروابي من قرب بقالة تنومة");
            add("اخر الخنساء مقابل عطار البحرين");
            add("كومامبو الالبان عمارة خير لمعى شحاتة بجوار المسجد");
            add("طريق المدينة");
            add("حي الجزيرة شارع 4");
            add("صهيب الرومي");
            add("طريق المدينة");
            add("طريق الملك عبدالله");
            add("حي الجزيرة شارع 4");
            add("طريق الملك عبدالله ارديف");
            add("صهيب الرومي");
            add("الفيحاء ٣٩ شارع البقيع");
            add("قرية شرما");
            add("الملك عبدالله");
            add("أبو الدرداء");
            add("علي بن ابي طالب");
            add("قرية شرما");
            add("قرية شرما");
            add("ابراهيم الجزار من شارع القسم المرج");
            add("علي بن ابي طالب");
            add("شارع 1");
            add("علي الكسائى");
            add("علي الكسائى");
            add("الماجد");
            add("كفر الدوار المراكبيه شارع عرفه سويلم");
            add("حي المحفل");
            add("حي المحفل");
            add("شارع 1");
            add("الامير محمد بن عبدالعزيز");
            add("الماجد");
            add("معاويه بن عمر");
            add("شارع مشعل");
            add("الامير محمد بن عبدالعزيز");
            add("جازان");
            add("شارع الملك عبدالعزيز - محافظة الاسياح - عين بن فهيد");
            add("الأمير  ممدوح");
            add("شارع الآبار");
            add("شارع محمد بن يسار");
            add("عبدالملك بن هشام");
            add("شارع خبر");
            add("حي اليرموك  جانب مدارس ماريا العالميه");
            add("شارع خبر");
            add("الامير نايف");
            add("معاويه بن عمر");
            add("مالك بن نويره");
            add("الامير نايف");
            add("المنتصر");
            add("السويلمي");
            add("السويلمي");
            add("الملك فيصل");
            add("الرايه");
            add("مقابل سوق المرجان");
            add("الرايه");
            add("قنا الشارع العام");
            add("مقابل سوق المرجان");
            add("مالك بن أهيب");
            add("الملك فهد");
            add("قنا الشارع العام");
            add("الخليفه المأمون");
            add("الامير نايف");
            add("مالك بن أهيب");
            add("شارع الاماره القديم");
            add("حمزة تفرع البترجي");
            add("الامير نايف");
            add("شارع الرياض");
            add("حمزة تفرع البترجي");
            add("زور وادعه");
            add("احد رفيدة");
            add("حي الرحاب");
            add("شارع الاماره القديم");
            add("شارع النجدة");
        }
    };

    private static List<String> result = new ArrayList<String>() {
        {
            add(" share' alameer masha'al bin abdulazziz");
            add("share' alsteen");
            add("share' alsteen");
            add("aalethaa'h");
            add("alameer masha'al bin abdulazziz");
            add("aalrhmanyeh 3");
            add("aalethaa'h");
            add("share' alamkronh");
            add("share' alamfroshat");
            add("share' alamkronh");
            add("tareeq alameer Mohammed bin Abed alazziz");
            add("jeddah share' alameer majid aalsbain fallaminjo mall aalshyeakh");
            add("tareeq alameer Mohammed bin Abed alazziz");
            add("komumbo share' salah salim bi janeb saydalia makram");
            add("alriyadh /alnassiryeh  share' /alama'thr /bi janeb sharika alkahraba");
            add("komumbo alalban Amara khayer lama'a shahath bi janeb almasjid");
            add("alqaseem bareeda hay al'amin muqabil aalstad alriyade");
            add("alriyadh .alrawda.taqato' share' alameer bandar ma' Abed alrahman alnassir");
            add("alriyadh .alrawda.taqato' share' alameer bandar ma' Abed alrahman alnassir");
            add("aalrhmanyeh 3");
            add("alsinae'ia aljaded");
            add("alsinae'ia aljaded");
            add("qaria sharma");
            add("alsinae'ia althaniya tareeq abqyeq sharika hala");
            add("qaria sharma");
            add("hay aldabbab muqabil aljabal alakhdr");
            add("hay aldabbab muqabil aljabal alakhdr");
            add("aladhm");
            add("aakhar aalkhnsa' muqabil a'atar albaharyen");
            add("bldyeh aalroabi min qurb baqalatanomh");
            add("aakhar aalkhnsa' muqabil a'atar albaharyen");
            add("komumbo alalban Amara khayer lama'a shahath bi janeb almasjid");
            add("tareeq almadina");
            add("hay aljazeera share' 4");
            add("shyeb aalromye");
            add("tareeq almadina");
            add("tareeq Almalik Abdullah");
            add("hay aljazeera share' 4");
            add("tareeq Almalik Abdullah ardyef");
            add("shyeb aalromye");
            add("alfayha' ٣٩ share' aalbqyea'");
            add("qaria sharma");
            add("Almalik Abdullah");
            add("abu aaldrda'");
            add("Ali bin abi talib");
            add("qaria sharma");
            add("qaria sharma");
            add("ibrahim aaljzar min share' aalqisim almarj");
            add("Ali bin abi talib");
            add("share' 1");
            add("Ali aalksa'ea");
            add("Ali aalksa'ea");
            add("aalmajid");
            add("kafar aaldowar alamrakbih share' a'arfh saoyelam");
            add("hay alamhfl");
            add("hay alamhfl");
            add("share' 1");
            add("alameer Mohammed bin abdulazziz");
            add("aalmajid");
            add("ma'awyeh bin omar");
            add("share' masha'al");
            add("alameer Mohammed bin abdulazziz");
            add("jazzan");
            add("share' Almalik abdulazziz - muhafatha alasyeah - ain bin fahyed");
            add("alameer  mamdouh");
            add("share' aalabar");
            add("share' Mohammed bin yassar");
            add("abdulmalik bin hisham");
            add("share' khabr");
            add("hay alyarmook  janib madaris maryea aala'alamyeh");
            add("share' khabr");
            add("alameer nayif");
            add("ma'awyeh bin omar");
            add("malik bin naoyerh");
            add("alameer nayif");
            add("aalmintsr");
            add("aalsoyelamye");
            add("aalsoyelamye");
            add("Almalik faisal");
            add("aalrayeh");
            add("muqabil souq almarjan");
            add("aalrayeh");
            add("qna alshare' alaam");
            add("muqabil souq almarjan");
            add("malik bin ahyeb");
            add("Almalik fahid");
            add("qna alshare' alaam");
            add("aalkhalifa alamumon");
            add("alameer nayif");
            add("malik bin ahyeb");
            add("share' alamarh alqadem");
            add("hamzataferi' aalbtrjye");
            add("alameer nayif");
            add("share' alriyadh");
            add("hamzataferi' aalbtrjye");
            add("zor waada'h");
            add("ahad rafedh");
            add("hay alrihab");
            add("share' alamarh alqadem");
            add("share' aalnjeddah");
        }
    };

    private static final Map<String, String> inputData  = new LinkedHashMap<>();
    private static final List<String> fileLists = Arrays.asList("abu_dhabi.csv", "dubai.csv", "other_ae.csv");

    public static void main(String[] args) throws IOException {

        System.out.println(CharUtils.isAscii('–') ? "YES" : "NO");
        loadDictData();
        Arabic2LatinProvider handler = new Arabic2LatinProvider();

//        for (String file : fileLists) {
//            System.out.println(file);
//            testCSVFileData(file);
//        }
//
//        /*
//         test cases
//         */
//
        Arabic2LatinProvider sample = new Arabic2LatinProvider();

//        int yesCnt = 0, noCut = 0;
//        Long time = System.currentTimeMillis();
//        for (int i = 0 ; i < data.size(); i++) {
//            String tranData = sample.transliterate(data.get(i));
//
//            if (result.get(i).trim().equals(tranData.trim())) {
//                yesCnt++;
//            } else {
//                System.out.println("NO " + data.get(i) + "   " + tranData + "   " + result.get(i));
//                noCut++;
//            }
//        }
//        System.out.println(yesCnt + "    " + noCut);
//        System.out.println("use time " + (System.currentTimeMillis() - time) );
        String data = "خلف سوق الصيني مقابل مدرسة ابن تيميه";
        System.out.println(data);
        System.out.println(sample.transliterate(data));
    }

    private static void loadDictData() {
        try {
            URL url = Resources.getResource("data.txt");
            for(Object data : Resources.readLines(url, Charset.defaultCharset())) {
                System.out.println(data);
                String[] dataList = StringUtils.split((String)data, ",");
                final String key = dataList[0].substring(1, dataList[0].length() - 1);
                final String value = dataList[1].substring(1, dataList[1].length() - 1);
                inputData.put(key, value);
            }
        } catch (IOException e) {

        }
    }

    private static void testCSVFileData(final String fileName) throws IOException
    {
        URL url = Resources.getResource(fileName);
        URL resourceUrl = Resources.getResource("");
        System.out.println(resourceUrl.getPath());

        File outFile = new File(resourceUrl.getPath() + "transliteration4_" + fileName);
        if (!outFile.exists()) {
            outFile.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(outFile, true);
        for (String lineData : Resources.readLines(url, Charset.defaultCharset())) {
            String[] dataList = StringUtils.split(lineData, ",");
            for (String item : dataList) {
                fileWriter.append(transliterate(item)).append(",");
            }
            fileWriter.append("\n");
        }
        fileWriter.close();
    }

}
