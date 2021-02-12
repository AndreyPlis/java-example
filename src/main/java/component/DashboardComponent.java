package component;

public interface DashboardComponent extends Cloneable, Comparable<DashboardComponent> {

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    int getSize();

    void setSize(int size);

    String render();

    void changeXY();

}