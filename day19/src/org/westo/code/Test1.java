import javax.sound.sampled.Line;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.security.cert.CertPathValidatorException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        HttpURLConnection connection=(HttpURLConnection) new URL("https://tieba.baidu.com/p/2256306796?red_tag=1781367364").openConnection();
        InputStream in = connection.getInputStream();
        List<String> list = new ArrayList<>();
        int count=1;
        //获得img标签正则
        String str="<img.*src=(.*?)*?>";
        //获得图片正则
        String str1="[a-zA-z]+://[^\\s]*\"";
        int len=0;
        byte[] bytes = new byte[1024 * 8];
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        //把数据读入集合中
        while(reader.readLine()!=null){
            String line = reader.readLine();
            list.add(line);
        }
        //遍历集合取出匹配正则的字符串
        for (String s : list) {
            Pattern p = Pattern.compile(str);
            p = Pattern.compile(str);
            Matcher m = p.matcher(s);
            if (m.find()) {
                String group = m.group();
                Matcher matcher = Pattern.compile(str1).matcher(group);
                if (matcher.find()) {
                    String group1 = matcher.group();
                    //返回src最后的双引号的位置
                    int i = group1.indexOf("\"");
                    //截取src双引号里的路径
                    String http = group1.substring(0, i);
                    System.out.println(http);
                    //打开链接
                    URL url = new URL(http);
                    //接收数据
                    InputStream inputStream = url.openStream();
                    //存放图片的位置
                    FileOutputStream write = new FileOutputStream("E:\\423\\" + (count++) + ".jpg");
                    //下载图片
                    while ((len = inputStream.read(bytes)) != -1) {
                        write.write(bytes, 0, len);
                    }
                }
            }
        }
        reader.close();
        connection.disconnect();
    }
}
