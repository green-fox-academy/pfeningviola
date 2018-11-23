import java.util.ArrayList;

public class Blog {
  private ArrayList<BlogPost> listOfBlogs;

  public Blog() {
    this.listOfBlogs = new ArrayList<>();
  }

  public void add(BlogPost post) {
    this.listOfBlogs.add(post);
  }

  public void delete(int indexNumber) {
    this.listOfBlogs.remove(listOfBlogs.get(indexNumber));
  }

  public void update(int indexNumber, BlogPost blog) {
    this.listOfBlogs.set(indexNumber, blog);
  }

  public ArrayList<BlogPost> getListOfBlogs() {
    return listOfBlogs;
  }

  public void setListOfBlogs(ArrayList<BlogPost> listOfBlogs) {
    this.listOfBlogs = listOfBlogs;
  }

  @Override
  public String toString() {
    return "Blog{" +
        "listOfBlogs=\n" + listOfBlogs +
        '}';
  }
}
