package component;

public class LabelComponent extends AbstractDashboardComponent {
    public LabelComponent(int x, int y, int id) {
        super(x, y, id);
    }

    public LabelComponent(int x, int y, int id, boolean visible) {
        super(x, y, id, visible);
    }

    @Override
    public String render() {
        return "label";
    }
}
