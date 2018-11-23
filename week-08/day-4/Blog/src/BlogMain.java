public class BlogMain {
  public static void main(String[] args) {
    BlogPost post1 = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04.");
    BlogPost post2 = new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10.");
    BlogPost post3 = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.","2017.03.28.");

    Blog travelling = new Blog();
    travelling.add(post1);
    travelling.add(post2);
    travelling.add(post3);

    System.out.println(travelling);
    System.out.println("--------------------");

    travelling.delete(0);
    System.out.println(travelling);
    System.out.println("----------------------");

    BlogPost newPost = new BlogPost("Kelly Smith", "Travel around the world", "klkajfjbfjbjebjbjdbkjeJFBJKÍFDJ", "2018.11.23");
    travelling.update(1, newPost);
    System.out.println(travelling);
  }
}
