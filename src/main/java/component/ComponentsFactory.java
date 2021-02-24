package component;


public class ComponentsFactory {


    public static enum Type {
        LABEL, IMAGE
    }

    public static DashboardComponent create(ComponentsFactory.Type type, int x, int y, int width, int height) {
        switch (type) {
            case IMAGE:
                return new ImageComponent(x, y, width, height);
            case LABEL:
                return new LabelComponent(x, y, width, height);
            default:
                throw new IllegalStateException("unknown type ");
        }
    }
}
