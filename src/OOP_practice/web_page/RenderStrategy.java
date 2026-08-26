package OOP_practice.web_page;

interface RenderStrategy {
    String render(TextElement element);
    String render(ImageElement element);
    String render(ButtonElement element);
}