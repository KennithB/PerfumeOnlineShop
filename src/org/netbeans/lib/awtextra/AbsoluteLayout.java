package org.netbeans.lib.awtextra;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class AbsoluteLayout implements LayoutManager2, Serializable {
    static final long serialVersionUID = -1919857869177073281L;

    protected Hashtable<Component, AbsoluteConstraints> constraints = new Hashtable<>();

    @Override
    public void addLayoutComponent(String name, Component comp) {
        throw new IllegalArgumentException();
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        constraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (Enumeration<Component> e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = e.nextElement();
            AbsoluteConstraints ac = constraints.get(comp);
            Dimension size = comp.getPreferredSize();
            int width = ac.getWidth();
            int height = ac.getHeight();
            if (width == -1) width = size.width;
            if (height == -1) height = size.height;
            if (ac.getX() + width > maxWidth) maxWidth = ac.getX() + width;
            if (ac.getY() + height > maxHeight) maxHeight = ac.getY() + height;
        }
        return new Dimension(maxWidth, maxHeight);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        int maxWidth = 0;
        int maxHeight = 0;
        for (Enumeration<Component> e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = e.nextElement();
            AbsoluteConstraints ac = constraints.get(comp);
            Dimension size = comp.getMinimumSize();
            int width = ac.getWidth();
            int height = ac.getHeight();
            if (width == -1) width = size.width;
            if (height == -1) height = size.height;
            if (ac.getX() + width > maxWidth) maxWidth = ac.getX() + width;
            if (ac.getY() + height > maxHeight) maxHeight = ac.getY() + height;
        }
        return new Dimension(maxWidth, maxHeight);
    }

    @Override
    public void layoutContainer(Container parent) {
        for (Enumeration<Component> e = constraints.keys(); e.hasMoreElements(); ) {
            Component comp = e.nextElement();
            AbsoluteConstraints ac = constraints.get(comp);
            Dimension size = comp.getPreferredSize();
            int width = ac.getWidth();
            int height = ac.getHeight();
            if (width == -1) width = size.width;
            if (height == -1) height = size.height;
            comp.setBounds(ac.getX(), ac.getY(), width, height);
        }
    }

    @Override
    public void addLayoutComponent(Component comp, Object constr) {
        if (!(constr instanceof AbsoluteConstraints)) {
            throw new IllegalArgumentException();
        }
        constraints.put(comp, (AbsoluteConstraints) constr);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    @Override
    public void invalidateLayout(Container target) {
    }
}
