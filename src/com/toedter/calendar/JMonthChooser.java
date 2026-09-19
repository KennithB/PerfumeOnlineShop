package com.toedter.calendar;

import javax.swing.JComboBox;
import java.awt.Dimension;

public class JMonthChooser extends JComboBox<String> {
    private static final String[] MONTHS = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    public JMonthChooser() {
        super(MONTHS);
        setPreferredSize(new Dimension(130, 30));
    }

    public int getMonth() {
        return getSelectedIndex();
    }

    public void setMonth(int month) {
        if (month >= 0 && month < 12) {
            setSelectedIndex(month);
        }
    }
}
