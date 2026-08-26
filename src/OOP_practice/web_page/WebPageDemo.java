package OOP_practice.web_page;

// =========================
// Demo
// =========================

public class WebPageDemo {
    public static void main(String[] args) {

        WebPage page = new WebPage("Amazon Interview Prep");

        page.addElement(new TextElement("Welcome to my interview preparation page."));
        page.addElement(new ImageElement(
                "https://example.com/banner.png",
                "Interview prep banner"
        ));
        page.addElement(new ButtonElement(
                "Start Practice",
                "https://example.com/practice"
        ));

        RenderStrategy htmlRenderer = new HtmlRenderStrategy();
        RenderStrategy plainTextRenderer = new PlainTextRenderStrategy();
        RenderStrategy markdownRenderer = new MarkdownRenderStrategy();

        System.out.println("=== HTML ===");
        System.out.println(page.render(htmlRenderer));

        System.out.println("\n=== PLAIN TEXT ===");
        System.out.println(page.render(plainTextRenderer));

        System.out.println("\n=== MARKDOWN ===");
        System.out.println(page.render(markdownRenderer));
    }
}