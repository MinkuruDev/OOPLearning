package SV24.NguyenTrungVinh.GHP.Obj;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TimesInWeek implements Comparable<TimesInWeek>{
    @XmlElement
    private DaysInWeek day;
    @XmlElement
    private TimesInDay time;

    private TimesInWeek(){} // for xml

    public TimesInWeek(DaysInWeek day, TimesInDay time){
        if(day == null || time == null)
            throw new IllegalArgumentException("'day' and 'time' can not be null");
        this.day = day;
        this.time = time;
    }

    public DaysInWeek getDay() {
        return day;
    }

    public TimesInDay getTime() {
        return time;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        switch(day){
            case Monday -> builder.append("Monday");
            case Tuesday -> builder.append("Tuesday");
            case Wednesday -> builder.append("Wednesday");
            case Thursday -> builder.append("Thursday");
            case Friday -> builder.append("Friday");
            case Saturday -> builder.append("Saturday");
            case Sunday -> builder.append("Sunday");
        }

        builder.append(" ");

        switch(time){
            case Morning -> builder.append("Morning");
            case Afternoon -> builder.append("Afternoon");
            case Evening -> builder.append("Evening");
        }
        return builder.toString();
    }

    @Override
    public int compareTo(TimesInWeek other) {
        int diff = day.getDayValues() - other.day.getDayValues();
        if(diff == 0) 
            return time.getValue() - other.time.getValue();
        return diff;
    }
}
