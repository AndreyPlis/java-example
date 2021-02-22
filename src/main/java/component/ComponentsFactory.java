package component;


public class ComponentsFactory {


    public static enum Type {
        LABEL, IMAGE
    }

    public static DashboardComponent create(ComponentsFactory.Type type, int x, int y) {
        switch (type) {
            case IMAGE:
                return new ImageComponent(x, y);
            case LABEL:
                return new LabelComponent(x, y);
            default:
                throw new IllegalStateException("unknown type ");
        }
    }
}
