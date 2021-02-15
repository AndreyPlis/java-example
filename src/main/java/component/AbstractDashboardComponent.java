package component;

import java.util.Objects;

public abstract class AbstractDashboardComponent implements DashboardComponent {

    private int x;
    private int y;
    private boolean visible = true;
    private final int id;

    public AbstractDashboardComponent(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public AbstractDashboardComponent(int x, int y, int id, boolean visible) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.visible = visible;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public abstract String render();

    @Override
    public void hide() {
        visible = false;
    }

    @Override
    public void show() {
        visible = true;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public int compareTo(DashboardComponent o) {
        if (this.y == o.getY())
            return Integer.compare(this.x, o.getX());
        return Integer.compare(this.y, o.getY());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractDashboardComponent)) return false;
        AbstractDashboardComponent that = (AbstractDashboardComponent) o;
        return getX() == that.getX() && getY() == that.getY() && isVisible() == that.isVisible() && getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), isVisible(), getId());
    }
}
