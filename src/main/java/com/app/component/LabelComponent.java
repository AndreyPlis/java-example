package com.app.component;

import java.util.Objects;

public class LabelComponent extends AbstractComponent {

    private String text;

    public LabelComponent(int x, int y, String text) {
        this.setX(x);
        this.setY(y);
        this.text = text;
    }

    @Override
    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return "label";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LabelComponent that = (LabelComponent) o;
        return this.getX() == that.getX() && this.getY() == that.getY() && Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), text);
    }

}
