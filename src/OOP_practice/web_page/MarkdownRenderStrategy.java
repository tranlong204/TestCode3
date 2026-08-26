package OOP_practice.web_page;

// =========================
// Markdown Renderer
// =========================

class MarkdownRenderStrategy implements RenderStrategy {

    @Override
    public String render(TextElement element) {
        return element.getText();
    }

    @Override
    public String render(ImageElement element) {
        return "![" + safe(element.getAltText()) + "](" + safe(element.getImageUrl()) + ")";
    }

    @Override
    public String render(ButtonElement element) {
        return "[" + safe(element.getLabel()) + "](" + safe(element.getActionUrl()) + ")";
    }

    private String safe(String value) {
        return value == null ? "" : value;
    }
}
