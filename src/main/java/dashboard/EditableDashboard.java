package dashboard;

public class EditableDashboard extends AbstractDashboard {
    @Override
    protected void render() {
        System.out.println("render editable");
    }

    @Override
    public String getClassName() {
        return "EditableDashboard";
    }

    public static class Builder {

        private EditableDashboard newDash;

        public Builder() {
            newDash = new EditableDashboard();
        }

        public Builder idDashboard(int idDashboard) {
            newDash.setIdDashboard(idDashboard);
            return this;
        }

        public Builder name(String name) {
            newDash.setName(name);
            return this;
        }

        public EditableDashboard build() {
            return newDash;
        }
    }
}
