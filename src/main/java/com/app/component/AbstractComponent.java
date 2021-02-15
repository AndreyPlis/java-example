package com.app.component;

public abstract class AbstractComponent implements DashboardComponent, Comparable<AbstractComponent> {

    private int x = 0;
    private int y = 0;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {

    }

    public abstract String getText();

    @Override
    public String render() {
        return "com/app/component";
    }

    @Override
    public int compareTo(AbstractComponent o) {
        return this.hashCode() - o.hashCode();
    }
}
