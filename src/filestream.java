import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;

public class filestream {
    public static void makefile(String args, int year, int month, int day) {
        File f = new File("\"bob/\"+year+\"-\"+mon+\"-\"+day+\".json\"");
        if(!f.isFile()) {
            LocalDate currentDate = LocalDate.now();
            String mon = month / 10 == 1 ? Integer.toString(month) : '0' + Integer.toString(month);
            String mont = currentDate.getMonthValue() / 10 == 1 ? Integer.toString(currentDate.getMonthValue()) : '0' + Integer.toString(currentDate.getMonthValue());
            String datetime = currentDate.getYear() + "-" + mont + "-" + currentDate.getDayOfMonth();
            StringBuilder sb = new StringBuilder();
            sb.append("{'breakfast': ''" + "\r\n" + " " + "'lunch': '" + args + "'" + "\r\n" + " " + "'dinner': ''" + "\r\n" + " " + "'date': '" + year + "-" + mon + "-" + day + "'"
                    + "\r\n" + " " + "'added': '" + datetime + "'}");
            try {
                OutputStream output = new FileOutputStream("bob/" + year + "-" + mon + "-" + day + ".json");
                byte[] by = sb.toString().getBytes();
                output.write(by);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
//{'breakfast': '차돌박이고추장찌개/쌀밥/돈육강정/병아리콩조림/깍두기/자몽/오레오오즈씨리얼/우유/숭늉'
//        'lunch': '차수수밥/모듬어묵탕/안동찜닭/비빔야채만두/애호박새우젓볶음/배추김치/아이스경단'
//        'dinner': '추억의도시락비빔밥/쌀밥/콩나물국/생선가스&양파크림소스/아몬드멸치볶음/마카로니마요범벅/깍두기/요구르트'
//       'date': '2019-09-30'
//      'added': '2019-09-29'}
