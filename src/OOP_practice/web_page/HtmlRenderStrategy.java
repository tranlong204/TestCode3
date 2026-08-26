package OOP_practice.web_page;

// =========================
// HTML Renderer
// =========================

class HtmlRenderStrategy implements RenderStrategy {

    @Override
    public String render(TextElement element) {
        return "<p>" + escape(element.getText()) + "</p>";
    }

    @Override
    public String render(ImageElement element) {
        return "<img src=\"" + escape(element.getImageUrl()) +
                "\" alt=\"" + escape(element.getAltText()) + "\" />";
    }

    @Override
    public String render(ButtonElement element) {
        return "<button onclick=\"location.href='" + escape(element.getActionUrl()) + "'\">" +
                escape(element.getLabel()) +
                "</button>";
    }

    private String escape(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
