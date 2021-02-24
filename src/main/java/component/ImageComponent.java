package component;

public class ImageComponent extends DashboardComponent {
    public ImageComponent(int x, int y,int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public String render() {
        return "image";
    }
}
