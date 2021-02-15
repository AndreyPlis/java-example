package component;

import dashboard.Dashboard;
import dashboard.EditableDashboard;
import dashboard.RunnableDashboard;

public class Builder {

    private ImageComponent image;
    private LabelComponent label;

    public void setImage(ImageComponent image) {
        this.image = image;
    }

    public void setLabel(LabelComponent label) {
        this.label = label;
    }

    public Dashboard buildEditableDashboard() {
        System.out.println("EditableDashboard is build");
        return new EditableDashboard(this);
    }

    public Dashboard buildRunnableDashboard() {
        System.out.println("RunnableDashboard is build");
        return new RunnableDashboard(this);
    }
}
