package dashboard;

public class RunnableDashboard extends AbstractDashboard {
    @Override
    protected void render() {
        System.out.println("render runnable");
    }

    @Override
    public String getClassName() {
        return "RunnableDashboard";
    }

    public static class Builder {

        private RunnableDashboard newDash;

        public Builder() {
            newDash = new RunnableDashboard();
        }

        public RunnableDashboard.Builder idDashboard(int idDashboard) {
            newDash.setIdDashboard(idDashboard);
            return this;
        }

        public RunnableDashboard.Builder name(String name) {
            newDash.setName(name);
            return this;
        }

        public RunnableDashboard build() {
            return newDash;
        }
    }
}
