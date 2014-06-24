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
        println map.b

        // Optional type system
        try {
            int number = 1
            number = "Hello"
        } catch (org.codehaus.groovy.runtime.typehandling.GroovyCastException e) {
            println "Cannot change type of explicitly typed variable"
        }
        def something = 1
        something = "Hello"

        // Closures
        def square = {
            it * it
        }
        println square(5)
        [1, 2, 3, 4, 5].collect(square)
    }
}
