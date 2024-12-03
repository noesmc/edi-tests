package by.softclub.edi.tests.testBase;

public enum Contour {
    DEV("http://192.168.194.14:10001/"),
    TEST("http://edi-test-web-nginx.scx"),
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
