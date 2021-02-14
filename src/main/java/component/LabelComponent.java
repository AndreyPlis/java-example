package component;

public class LabelComponent extends AbstractDashboardComponent {
    public LabelComponent(int x, int y, String name, boolean visible, int idComponent) {
        super(x, y, name, visible, idComponent);
    }

    @Override
    public String render() {
        return "label";
    }

    @Override
    public void rename(String name) {
        setName(name);
    }

    @Override
    public void show() {
        setVisible(true);
    }

    @Override
    public void hide() {
        setVisible(false);
    }

    @Override
    public String getClassName() {
        return "LabelComponent";
    }
}
