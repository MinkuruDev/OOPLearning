package SV24.NguyenTrungVinh.BTH10_3;

public class News implements INews{
    private static int nextID = 1;
    private int id;
    private String title, author, publishDate;
    protected Object content;
    private float averageRate;
    private int[] rateList;

    public News(String title, String author, String publishDate){
        id = nextID;
        nextID++;
        this.title = title;
        this.author = author;
        this.publishDate = publishDate;
        rateList = new int[6];
    }

    protected void setContent(Object content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public float getAverageRate() {
        calculate();
        return averageRate;
    }

    public Object getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void rate(int stars){
        rateList[stars] ++;
    }

    public void calculate(){
        int sum = 0;
        int total = 0;
        for(int i = 1; i<=5; i++){
            sum += i * rateList[i];
            total += rateList[i];
        }

        averageRate = ((float) sum) / (float) total;
    }

    @Override
    public void Display() {
        System.out.println("--- news ---");
        System.out.println("Title: " + title);
        System.out.println("Publish date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Average rate: " + getAverageRate());
    }
    
}
