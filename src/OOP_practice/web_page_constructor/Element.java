package OOP_practice.web_page_constructor;

interface Element {
    String render(RenderStrategy strategy);
    int getWordCount();
}