package OOP_practice.web_page;

class ImageElement implements Element {
    private final String imageUrl;
    private final String altText;

    public ImageElement(String imageUrl, String altText) {
        this.imageUrl = imageUrl;
        this.altText = altText;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getAltText() {
        return altText;
    }

    @Override
    public String accept(RenderStrategy renderer) {
        return renderer.render(this);
    }

    @Override
    public int getWordCount() {
        return 0;
    }
}