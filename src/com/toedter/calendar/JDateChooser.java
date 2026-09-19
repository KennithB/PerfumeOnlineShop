package com.toedter.calendar;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Date;

public class JDateChooser extends JPanel {
    private final JSpinner spinner;
    private final SpinnerDateModel model;

    public JDateChooser() {
        super(new BorderLayout());
        model = new SpinnerDateModel();
        spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
        spinner.setEditor(editor);
        add(spinner, BorderLayout.CENTER);
        setPreferredSize(new Dimension(130, 30));
    }

    public Date getDate() {
        return model.getDate();
    }

    public void setDate(Date date) {
        if (date != null) {
            model.setValue(date);
        }
    }
}
