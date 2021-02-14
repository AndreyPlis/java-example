package component;

public interface DashboardComponent extends Comparable<DashboardComponent> {

    public abstract String render();

    public abstract void rename(String name);

    public abstract void show();

    public abstract void hide();

    public abstract int getIdComponent();

    public abstract String getClassName();

    public abstract int getX();

    public abstract int getY();

    public abstract String getName();

    public abstract boolean getVisible();

}
