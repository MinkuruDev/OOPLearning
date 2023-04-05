package SV24.NguyenTrungVinh.BTH10_3;

public class ImageNews extends News{
    
    public ImageNews(String title, String author, String publishDate) {
        super(title, author, publishDate);
        content = "";
    }
    
    public void addImage(String url){
        content = (content.toString()) + url + ";\n";
    }

    @Override
    public void Display() {
        super.Display();
        System.out.println("Image Url(s):\n" + content);
    }
}
