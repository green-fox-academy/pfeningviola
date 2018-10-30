public class SimpleReplaceAndUrlFixer {
    public static void main(String[] args) {
        //SimpleReplace
        String example = "In a dishwasher far far away";
        System.out.println(example.replace("dishwasher", "galaxy"));

        String correctExample = example.replace("dishwasher", "galaxy");
        System.out.println(correctExample);

        //UrlFixer
        String url = "https//www.reddit.com/r/nevertellmethebots";
        String correctUrl = url.substring(0, 4) + ":" + url.substring(5);
        correctUrl = correctUrl.replace("bots", "odds");
        System.out.println(correctUrl);

        String correctUrl2 = url.replace("//", "://");
        System.out.println(correctUrl2.replace("bots", "odds"));
    }
}
