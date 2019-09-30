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
