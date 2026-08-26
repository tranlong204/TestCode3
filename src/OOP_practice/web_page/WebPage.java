package OOP_practice.web_page;

// =========================
// Manager
// =========================

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class WebPage {
    private final String title;
    private final List<Element> elements = new ArrayList<>();

    public WebPage(String title) {
        this.title = title;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public List<Element> getElements() {
        return Collections.unmodifiableList(elements);
    }

    public String getTitle() {
        return title;
    }

    public int getElementCount() {
        return elements.size();
    }

    public int getWordCount() {
        int total = 0;
        for (Element element : elements) {
            total += element.getWordCount();
        }
        return total;
    }

    public String render(RenderStrategy renderer) {
        StringBuilder sb = new StringBuilder();
        for (Element element : elements) {
            sb.append(element.accept(renderer)).append("\n");
        }
        return sb.toString().trim();
    }
}