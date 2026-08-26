package OOP_practice.web_page_constructor;

class TextElement implements Element {
    private final String text;

    public TextElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String render(RenderStrategy strategy) {
        return "";
    }

    @Override
    public int getWordCount() {
        if (text == null || text.isBlank()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }
}