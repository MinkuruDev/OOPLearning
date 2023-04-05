package SV24.NguyenTrungVinh.BTH10_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
    static ArrayList<News> newsList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option = 0;

        while(true){
            printOption();
            option = Integer.parseInt(scanner.nextLine());
            switch(option){
                case 1:
                    insertNews();
                    break;

                case 2:
                    showAllNews();
                    break;

                case 3:
                    averageRate();;
                    break;

                case 4:
                    break;

                case 5:
                    newsList = new ArrayList<>();
                    break;

                default:
                    System.out.println("Invalid option");
            }
            if(option == 4)
                break;
        }
        scanner.close();
    }

    public static void insertNews(){
        System.out.println("===Insert news===");
        System.out.print("Input title: ");
        String title = scanner.nextLine();
        System.out.print("Input Author: ");
        String author = scanner.nextLine();
        System.out.print("Input publish date(any format): ");
        String pd = scanner.nextLine();
        News news = null;

        System.out.print("Input news type (Text-t/Image-i)");
        if(scanner.nextLine().equals("t")){
            System.out.print("Input text content: ");
            String content = scanner.nextLine();
            TextNews textNews =new TextNews(title, author, content);
            textNews.setContent(content);
            news = textNews;
        }else{
            ImageNews imageNews = new ImageNews(title, author, pd);
            for(int i = 0; i<3; i++){
                System.out.print("Input image url #" + (i+1) + "(# to quit): ");
                String url = scanner.nextLine();
                if(url.equals("#")) break;
                imageNews.addImage(url);
            }

            news = imageNews;
        }

        System.out.print("Input rate #1(1-5): ");
        news.rate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Input rate #2(1-5): ");
        news.rate(Integer.parseInt(scanner.nextLine()));
        System.out.print("Input rate #3(1-5): ");
        news.rate(Integer.parseInt(scanner.nextLine()));

        newsList.add(news);
    }

    public static void showAllNews(){
        System.out.println("===All news===");
        for(News news : newsList){
            news.Display();
        }
        System.out.println();
    }

    public static void averageRate(){
        System.out.println("===Average rate===");
        for(News news : newsList){
            news.calculate();
            news.Display();
        }
        System.out.println();
    }    

    public static void printOption(){
        System.out.println("\n=====News viewer=====");
        System.out.println("1. Insert news");
        System.out.println("2. View list news");
        System.out.println("3. Average rate");
        System.out.println("4. Exit");
        System.out.println("5. Continue");
        System.out.print("Your option: ");
    }

}
