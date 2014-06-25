class JavaDifferences {
    public static void main(String[] args) {
        // int[] x = new int[] { 1, 2, 3 };
        def x = [1, 2, 3]

        // HashMap<String, Integer> map = new HashMap<String, Integer>();
        // map.put("a", 1);
        // map.put("b", 2);
        // map.put("c", 3);
        // System.out.println(map.get("b"));
        def map = ["a": 1, "b": 2, "c": 3]
        println map["b"]
            // or
        println map.b

        // Optional type system
        try {
            int number = 1
            number = "Hello"
        } catch (org.codehaus.groovy.runtime.typehandling.GroovyCastException e) {
            println "Cannot change type of explicitly typed variable"
        }

        def something = 1
        something = "Hello" // Operation completes successfully

        // Closures
        def square = {
            it * it // `it` is special keyword passed to closures
        }
        println square(5)
        [1, 2, 3, 4, 5].collect(square)

        // Regex match
        println "Hello" ==~ /^[a-zA-Z]+$/ // True

        // Matching groups
        def matcher = ("Hello world" =~ /(\S+) (\S+)/)
        // matcher is 2-D; first index is the match number, second index
        // refers to the capture group within each match
        println matcher[0]    // [["Hello world"], [Match 2], ...]
        println matcher[0][1] // "Hello" (first group within match)

        // Replacement
        matcher = ("duck duck duck" =~ /(\S+)/)
        println matcher.replaceFirst("goose") // "goose duck duck"
        println matcher.replaceAll("goose")   // "goose goose goose"
    }
}
