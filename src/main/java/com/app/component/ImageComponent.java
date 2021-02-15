package com.app.component;

import java.util.Objects;

public class ImageComponent extends AbstractComponent {

    private String URL;

    public ImageComponent(int x, int y, String url) {
        this.setX(x);
        this.setY(y);
        URL = url;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    @Override
    public String getText() {
        return "";
    }

    @Override
    public String render() {
        return "image";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageComponent that = (ImageComponent) o;
        return this.getX() == that.getX() && this.getY() == that.getY() && Objects.equals(URL, that.URL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getX(), this.getY(), URL);
    }
}
