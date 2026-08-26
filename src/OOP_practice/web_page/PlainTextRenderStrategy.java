package OOP_practice.web_page;

// =========================
// Plain Text Renderer
// =========================

class PlainTextRenderStrategy implements RenderStrategy {

    @Override
    public String render(TextElement element) {
        return element.getText();
    }

    @Override
    public String render(ImageElement element) {
        return "[Image: " + element.getAltText() + "]";
    }

    @Override
    public String render(ButtonElement element) {
        return "[Button: " + element.getLabel() + " -> " + element.getActionUrl() + "]";
    }
}