package OOP_practice.web_page_constructor;

interface RenderStrategy {
    String render(TextElement element);
    String render(ButtonElement element);
}