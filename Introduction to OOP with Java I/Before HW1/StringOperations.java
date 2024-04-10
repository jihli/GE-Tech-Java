public class StringOperations {
    public static void main(String[] args) {
        String firstString = "JIHAO LI";
        System.out.println(firstString);

        String fString_ = firstString.replace("J","A").replace("I","Z");
        System.out.println(fString_);

        String Url = "www.gatech.edu";
        System.out.println(Url);

        String[] UrlParts = Url.split("\\.");
        String UrlName = UrlParts[1] + "1331";
        System.out.println(UrlName);
    }
}
