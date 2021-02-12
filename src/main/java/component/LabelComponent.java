package component;

public class LabelComponent implements DashboardComponent {

    private int x;
    private int y;
    private int size;

    public LabelComponent(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
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
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String render() {
        return "label";
    }

    @Override
    public void changeXY() {
        x = getY();
        y = getX();
    }

    @Override
    public int compareTo(DashboardComponent o) {
        return this.getSize() - o.getSize();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        LabelComponent guest = (LabelComponent) obj;
        return x == guest.getX() && y == guest.getY() && size == guest.getSize();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + size;
        return result;
    }
}
