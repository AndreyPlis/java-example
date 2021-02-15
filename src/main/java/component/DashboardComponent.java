package component;

public interface DashboardComponent {

    String getName();

    void setName(String name);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    String render();

    void rename(String changeName);

    void replace(int xChange, int yChange);

    boolean equals(DashboardComponent component1);

    boolean equalsHashCode(DashboardComponent component1, DashboardComponent component2);

}
