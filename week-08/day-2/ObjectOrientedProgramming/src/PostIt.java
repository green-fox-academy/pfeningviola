public class PostIt {
  private String backgroundColor;
  private String text;
  private String textColor;

  public PostIt(String backgroundColor, String text, String textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

  public String getBackgroungColor() {
    return backgroundColor;
  }

  public String getText() {
    return text;
  }

  public String getTextColor() {
    return textColor;
  }

  public void setBackgroungColor(String backgroungColor) {
    this.backgroundColor = backgroungColor;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setTextColor(String textColor) {
    this.textColor = textColor;
  }

  @Override
  public String toString() {
    return "PostIt{" +
        "backgroundColor='" + backgroundColor + '\'' +
        ", text='" + text + '\'' +
        ", textColor='" + textColor + '\'' +
        '}';
  }
}
