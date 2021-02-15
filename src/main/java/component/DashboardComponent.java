package component;

public interface DashboardComponent extends Comparable<DashboardComponent> {
    public int getX();

    public void setX(int x);

    public int getY();

    public void setY(int y);

    public String render();

    public void hide();

    public void show();

    public boolean isVisible();

    public int getId();
}
