package OOP_practice.web_page_constructor;

// =========================
// Demo
// =========================

public class WebPageDemo {
    public static void main(String[] args) {
        WebPage page = new WebPage("Amazon Interview Prep", new PlainTextRenderStrategy());

        page.addElement(new TextElement("Welcome to my interview preparation page."));
        page.addElement(new ButtonElement(
                "Start Practice",
                "https://example.com/practice"
        ));


        System.out.println("\n=== PLAIN TEXT ===");
        System.out.println(page.render());

    }
}