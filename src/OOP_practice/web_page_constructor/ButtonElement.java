package OOP_practice.web_page_constructor;

class ButtonElement implements Element {
    private final String label;
    private final String actionUrl;

    public ButtonElement(String label, String actionUrl) {
        this.label = label;
        this.actionUrl = actionUrl;
    }

    public String getLabel() {
        return label;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    @Override
    public String render(RenderStrategy strategy) {
        return "";
    }

    @Override
    public int getWordCount() {
        if (label == null || label.isBlank()) {
            return 0;
        }
        return label.trim().split("\\s+").length;
    }
}
