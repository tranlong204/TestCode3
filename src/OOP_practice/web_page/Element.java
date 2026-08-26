package OOP_practice.web_page;

interface Element {
    String accept(RenderStrategy renderer);
    int getWordCount();
}