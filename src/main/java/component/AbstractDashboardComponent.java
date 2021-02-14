package component;

import java.util.Comparator;
import java.util.Objects;

public abstract class AbstractDashboardComponent implements DashboardComponent {

    private int x;
    private int y;
    private String name;
    private boolean visible;
    private int idComponent;

    public AbstractDashboardComponent(int x, int y, String name, boolean visible, int idComponent) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.visible = visible;
        this.idComponent = idComponent;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getIdComponent() {
        return idComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDashboardComponent that = (AbstractDashboardComponent) o;
        return x == that.x && y == that.y && visible == that.visible && name.equals(that.name) && idComponent == that.idComponent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, name, visible, idComponent);
    }

    @Override
    public int compareTo(DashboardComponent o) {
        int result;
        result = Integer.compare(getIdComponent(), o.getIdComponent());
        return result;
    }

}
