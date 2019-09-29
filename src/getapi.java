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
//{'breakfast': '차돌박이고추장찌개/쌀밥/돈육강정/병아리콩조림/깍두기/자몽/오레오오즈씨리얼/우유/숭늉'
//        'lunch': '차수수밥/모듬어묵탕/안동찜닭/비빔야채만두/애호박새우젓볶음/배추김치/아이스경단'
//        'dinner': '추억의도시락비빔밥/쌀밥/콩나물국/생선가스&양파크림소스/아몬드멸치볶음/마카로니마요범벅/깍두기/요구르트'
//       'date': '2019-09-30'
//      'added': '2019-09-29'}