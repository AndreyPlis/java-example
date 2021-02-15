package component;

public class ImageComponent extends AbstractDashboardComponent {
    public ImageComponent(int x, int y, int id) {
        super(x, y, id);
    }

    public ImageComponent(int x, int y, int id, boolean visible) {
        super(x, y, id, visible);
    }

    @Override
    public String render() {
        return "image";
    }
}
