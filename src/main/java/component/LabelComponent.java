package component;

import java.util.*;

public class LabelComponent extends DashboardComponent implements Cloneable{

    String name = null;

    public LabelComponent(int x, int y) {
        super(x, y);
    }

    @Override
    public String render() {
        return "label";
    }

    @Override
    public LabelComponent clone() throws CloneNotSupportedException {
        return (LabelComponent) super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabelComponent that = (LabelComponent) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
