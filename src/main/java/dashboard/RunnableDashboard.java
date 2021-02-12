package dashboard;

import component.DashboardComponent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RunnableDashboard extends AbstractDashboard {

    public RunnableDashboard() {
    }

    @Override
    protected void render() {
        System.out.println("render runnable");
    }

    @Override
    public Dashboard clone() {
        RunnableDashboard dashboardClone = new RunnableDashboard();
        for (Object item : getComponents()) {
            dashboardClone.addComponent((DashboardComponent) item);
        }
        return dashboardClone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }

        RunnableDashboard guest = (RunnableDashboard) obj;

        if (this.componentsSize() != guest.componentsSize()) {
            return false;
        }
        for (int i = 0; i < guest.componentsSize(); i++) {
            if (this.getElementX(i) != guest.getElementX(i) || this.getElementY(i) != guest.getElementY(i) || this.getElementSize(i) != guest.getElementSize(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        for (int i = 0; i < this.componentsSize(); i++) {
            result = prime * result + this.getElementX(i);
            result = prime * result + this.getElementY(i);
            result = prime * result + this.getElementSize(i);
        }
        return result;
    }

    public static class Builder {

        private List<DashboardComponent> components = new ArrayList<>();

        public Builder() {

        }

        public Builder addComponents(ArrayList<DashboardComponent> inputComponents) {
            this.components.addAll(inputComponents);
            return this;
        }

        public Builder addElement(DashboardComponent inputElement) {
            this.components.add(inputElement);
            return this;
        }

        public RunnableDashboard build() {
            return new RunnableDashboard(this);
        }
    }

    private RunnableDashboard(Builder builder) {
        for (int i = 0; i < builder.components.size(); i++) {
            addComponent(builder.components.get(i));
        }
    }

}
