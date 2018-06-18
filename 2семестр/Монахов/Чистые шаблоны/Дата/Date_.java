import java.util.Iterator;
import java.util.*;
public class Date_ implements Comparable<Date_> {

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    private final int day;
    private final int month;
    private final int year;

    public Date_(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    @Override
    public int compareTo(Date_ that)
    {
        if(this.year>that.getYear()) return+1;
        if(this.year<that.getYear())return -1;
        if(this.month>that.getMonth())return +1;
        if(this.month<that.getMonth())return -1;
        if(this.day>that.getDay())return +1;
        if(this.day<that.getDay())return -1;
        return 0;
    }

    @Override
    public String toString()
    {
        String[] months = new String[]{
                "",
                "января",
                "февраля",
                "марта",
                "апреля",
                "мая",
                "июня",
                "июля",
                "августа",
                "сентября",
                "октября",
                "ноября",
                "декабря"
        };
        return ""+this.day+" "+months[this.month]+" "+this.year+" ";
    }
}
