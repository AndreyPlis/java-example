package component;

import java.util.*;

public abstract class DashboardComponent {

    private int x;
    private int y;

    public DashboardComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract String render();

    public Boolean isCoodsBelowZero() {
        return this.x < 0 || this.y < 0;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DashboardComponent that = (DashboardComponent) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Boolean hasIntersects(int x, int y) {
        if (x >= this.x && x <= this.y)
            return true;
        if (y >= this.x && y <= this.y)
            return true;
        return false;
    }
}
