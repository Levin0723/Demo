package text01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * unittest
 * Created by 黄桂道 on 2017-1-6.
 */
public class UnitText {

    public String getDate() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String test = sdf.format(date);
        return test;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        return a/b;
    }


}
