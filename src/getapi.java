import kr.go.neis.api.School;
import kr.go.neis.api.SchoolException;
import kr.go.neis.api.SchoolMenu;

import java.time.LocalDate;
import java.util.List;

public class getapi {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        for(int i = 0;i<=currentDate.getDayOfMonth();i++) {
            String lu = "";
            try {
                School school = School.find(School.Region.GYEONGGI, "한국디지털미디어고등학교");
                List<SchoolMenu> menu = school.getMonthlyMenu(currentDate.getYear(), currentDate.getMonthValue());
                lu = menu.get(i).lunch;
            } catch (SchoolException e) {
                e.printStackTrace();
            }
            lu = lu.replaceAll("(\r\n|\r|\n|\n\r)", "~");
            lu = lu.replaceAll("&amp;","&");
            lu = lu.replaceAll("\\*","&");
            String tmp = lu;
            lu = cleaning(tmp).replaceAll("~","/");
            if(lu.length() > 10) {
                filestream.makefile(lu, currentDate.getYear(), currentDate.getMonthValue(), i + 1);
            }
        }
    }

    private static String cleaning(String args) {
        int validate = 1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<args.length();i++){
            validate += args.charAt(i) == '~' ? 1 : 0;
            if(validate == 1) {
                validate -= args.charAt(i) == '(' ? 1 : 0;
                validate -= numcheck(args.charAt(i)) ? 0 : 1;
            }
            if(validate == 1){
                sb.append(args.charAt(i));
            }
        }
        return sb.toString();
    }

    private static boolean numcheck(char at) {
        return at < 48 || at > 58 ? true : false; // 숫자 아니면 트루
    }
}
