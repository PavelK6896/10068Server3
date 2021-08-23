package app.web.pavelk.server3.back5;

import spark.Spark;

public class Back5 {
    public static void main(String[] arg) {
        Spark.port(8080);
        Spark.get("/", (request, response) -> "Back 5 ok");
    }
}
