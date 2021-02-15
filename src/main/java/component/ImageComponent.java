package component;

public class ImageComponent implements DashboardComponent {
    private String name;
    private int x, y;

    public ImageComponent(int x, int y, String name) {
        this.name = name;
        this.x = x;
        this.y = y;
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

    @Override
    public String render() {
        return "image";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void rename(String changeName) {
        this.name = changeName;
    }

    @Override
    public void replace(int xChange, int yChange) {
        this.x = xChange;
        this.y = yChange;
    }

    @Override
    public boolean equals(DashboardComponent component) {
        return super.equals(component);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equalsHashCode(DashboardComponent component1, DashboardComponent component2) {
        int result1 = component1.hashCode();
        int result2 = component2.hashCode();
        if (result1 == result2) {
            return true;
        } else
            return false;
    }
}
