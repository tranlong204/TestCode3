package OOP_practice.web_page_constructor;

// =========================
// Plain Text Renderer
// =========================

class PlainTextRenderStrategy implements RenderStrategy {

    @Override
    public String render(TextElement element) {
        return element.getText();
    }

    @Override
    public String render(ButtonElement element) {
        return "[Button: " + element.getLabel() + " -> " + element.getActionUrl() + "]";
    }
}