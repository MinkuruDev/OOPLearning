package SV24.NguyenTrungVinh.GHP.UI;

import SV24.NguyenTrungVinh.GHP.Obj.DaysInWeek;
import SV24.NguyenTrungVinh.GHP.Obj.TimesInDay;
import SV24.NguyenTrungVinh.GHP.Obj.TimesInWeek;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class ScheduleForm {
    private JPanel schedulePanel;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JCheckBox checkBox12;
    private JCheckBox checkBox13;
    private JCheckBox checkBox14;
    private JCheckBox checkBox15;
    private JCheckBox checkBox16;
    private JCheckBox checkBox17;
    private JCheckBox checkBox18;
    private JCheckBox checkBox19;
    private JCheckBox checkBox20;
    private JCheckBox checkBox21;
    private final JCheckBox[] checkBoxes = {
            checkBox1,
            checkBox2,
            checkBox3,
            checkBox4,
            checkBox5,
            checkBox6,
            checkBox7,
            checkBox8,
            checkBox9,
            checkBox10,
            checkBox11,
            checkBox12,
            checkBox13,
            checkBox14,
            checkBox15,
            checkBox16,
            checkBox17,
            checkBox18,
            checkBox19,
            checkBox20,
            checkBox21
    };
    public ScheduleForm(){

    }

    public int timesToIndex(TimesInWeek times){
        return times.getDay().getDayValues() +
                times.getTime().getValue() * 7;
    }

    public TimesInWeek indexToTimes(int index){
        int daysValue = index % 7;
        int timesValue = index / 7;

        DaysInWeek days = DaysInWeek.Monday;
        for(DaysInWeek day : DaysInWeek.values()){
            if(day.getDayValues() == daysValue){
                days = day;
                break;
            }
        }

        TimesInDay times = TimesInDay.Morning;
        for(TimesInDay time : TimesInDay.values()){
            if(time.getValue() == timesValue){
                times = time;
                break;
            }
        }

        return new TimesInWeek(days, times);
    }

    public void uncheckAll(){
        for(JCheckBox checkBox : checkBoxes)
            checkBox.setSelected(false);
    }

    public void setSchedule(Set<TimesInWeek> schedule, boolean editable){
        uncheckAll();
        for(TimesInWeek t : schedule){
            int index = timesToIndex(t);
            checkBoxes[index].setSelected(true);
        }

        for (JCheckBox checkBox : checkBoxes){
            checkBox.setEnabled(editable);
        }
    }

    public TreeSet<TimesInWeek> getSchedule(){
        TreeSet<TimesInWeek> result = new TreeSet<>();
        for(int i = 0; i<checkBoxes.length; i++){
            if(checkBoxes[i].isSelected())
                result.add(indexToTimes(i));
        }
        return result;
    }

    public JPanel getSchedulePanel() {
        return schedulePanel;
    }
}
