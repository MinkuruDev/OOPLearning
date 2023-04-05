package SV24.NguyenTrungVinh.BTH10_3;

public class TextNews extends News{
    public TextNews(String title, String author, String publishDate) {
        super(title, author, publishDate);

        content = "";
    }

    @Override
    public void Display() {
        super.Display();
        System.out.println("TextContent: " + content.toString());
    }

    public void setContent(String content) {
        super.setContent(content);
    }
    
}
