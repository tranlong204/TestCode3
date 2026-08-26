package OOP_practice.web_page;

class TextElement implements Element {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String accept(RenderStrategy renderer) {
        return renderer.render(this);
    }

    @Override
    public int getWordCount() {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
}