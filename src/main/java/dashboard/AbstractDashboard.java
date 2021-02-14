package dashboard;

import component.*;

import java.util.*;

public abstract class AbstractDashboard implements Dashboard {

    private List<DashboardComponent> components = new ArrayList<>();
    private int idDashboard;
    private String name;

    public void setIdDashboard(int idDashboard) {
        this.idDashboard = idDashboard;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDashboard() {
        return idDashboard;
    }

    public String getName() {
        return name;
    }

    @Override
    public void redirect(String dashboardUrl) {
        System.out.println("metod redirect to " + dashboardUrl);
    }

    @Override
    public void search(String search) {
        System.out.println("metod search " + search);
    }

    protected abstract void render();

    @Override
    public void start() {
        System.out.println("starting...");
        render();
    }

    @Override
    public void stop() {
        System.out.println("stop...");
    }

    @Override
    public void addComponent(DashboardComponent component) {
        components.add(component);
    }

    @Override
    public void removeComponent(DashboardComponent component) {
        components.remove(component);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractDashboard that = (AbstractDashboard) o;
        //   return components.equals(that.components);

        if (components.containsAll(that.components) & that.components.containsAll(components))
            return true;
        else
            return false;
    }

    @Override
    public int hashCode() {
        //    return Objects.hash(components);

        int hashCode = 1;
        for (int i = 0; i < components.size(); i++) {
            hashCode = 31 * hashCode + components.get(i).hashCode();
        }
        return hashCode;

    }

    @Override
    public void sort() {
        Collections.sort(components);
    }

    @Override
    public Dashboard clone() {
        Dashboard cloneDashboard;

        if (this.getClassName().equals("EditableDashboard")) {
            cloneDashboard = new EditableDashboard();
        } else {
            cloneDashboard = new RunnableDashboard();
        }

        try {
            super.clone();
            cloneDashboard.setName(this.getName());
            cloneDashboard.setIdDashboard(this.getIdDashboard());

            for (int i = 0; i < this.components.size(); i++) {

                if (this.components.get(i).getClassName().equals("ImageComponent")) {
                    cloneDashboard.addComponent(new ImageComponent(this.components.get(i).getX(), this.components.get(i).getY(), this.components.get(i).getName(), this.components.get(i).getVisible(), this.components.get(i).getIdComponent()));
                }

                if (this.components.get(i).getClassName().equals("LabelComponent")) {
                    cloneDashboard.addComponent(new LabelComponent(this.components.get(i).getX(), this.components.get(i).getY(), this.components.get(i).getName(), this.components.get(i).getVisible(), this.components.get(i).getIdComponent()));
                }

            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return cloneDashboard;
    }

}
