function test() {
    alert("js file accessed");
}

function testBuildUrl() {
    var paramMap  = new Map();

    paramMap.set("query","huong");
    paramMap.set("page", 1);
    paramMap.set("categoryId", [1, 2, 3]);
    paramMap.set("sort", "rating-up");

    console.log("url=" + buildUrl("http://localhost:8080/course-source-webappWeb/resources/course", paramMap));
    alert("url=" + buildUrl("http://localhost:8080/course-source-webappWeb/resources/course", paramMap));

}