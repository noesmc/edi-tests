package by.softclub.edi.testBase;

public enum Contour {
    DEV("http://192.168.194.14:10001/"),
    TEST("http://192.168.194.28"),
    TV("http://192.168.194.47"),
    PUBBIDMART("https://edi-pub.bidmart.by"),
    PUBSTT("https://edi-pub.ctt.by/");

    private final String url;

    Contour(String url ) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

}
