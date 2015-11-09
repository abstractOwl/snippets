//
// Notes from the golang book <http://www.golang-book.com/>. This doesn't
// necessarily (and probably doesn't) compile.
//

package main

import "fmt"
import "testing"
import "time"

var someGlobal string = "I am a Global"

func main() {

// == VARIABLES ==

    var x string =  "Hello World"
    y := "Foo"

    fmt.Println(x)
    fmt.Println(y)

    // Creating a const
    const PI = 3.14

    fmt.Println(PI)


// == CONTROL STRUCTURES ==

    // Conditional
    if 1 == 2 {
        // Do something
    } else if 1 < 2 {
        // Do something else
    } else {
        // Final case
    }

    // Switch statement
    // Note: No fall-through!
    switch 2 {
    case 1: fmt.Println("One")
    case 2: fmt.Println("Two")
    default: fmt.Println("Unknown!")
    }

    // For loop
    // Note: No other loops, e.g. `while`, `do`, `until`, `foreach`, can all
    //         be constructed with `for`.
    for i := 1; i <= 10; i++ {
        fmt.Println(i)
    }


// == ARRAYS ==

    var a [5]int // Array of length 5, autofilled with 0's

    // Iterating over array
    var total float64 = 0
    for i := 0; i < len(a); i++ {
        total += float64(a[i])
    }
    fmt.Println("Average: ", total / float64(len(x)))

    // Alternate method
    var sum float64 = 0
    for i, value := range a { // i hold current index, value holds array value
        i += 0 // Prevent "i unused" error. Can solve by replacing i with `_`,
               //   signifying an unneeded value
        sum += float64(value)
    }
    fmt.Println("Average2: ", sum / float64(len(x)))

    // Inline array
    a2 := [5] float64 { 1, 2, 3, 4, 5 }

    // In multi-line notation, comma required after last item
    _ = [3] float64 {
        1,
        2,
        3,
    }

    // Array slices
    slice := make([]float64, 5) // Creates a slice associated with underlying
                                // `float64` array of length 5

    slice2 := a2[0:3] // slice from 0 to 3, [inclusive, non-inclusive).
                      // both start and end are optional, defaults to
                      // [0, len(a)]

    // Slice functions
    copy(slice2, slice) // Copies contents of `slice` into `slice2`
    _ = append(slice2, 4, 5) // Appends `4` and `5` to the end of `slice2`


// == MAPS ==
    some_map := make(map[string]int) // Map:String => Int

    // Insert
    some_map["key"] = 42
    // Delete
    delete(some_map, "key")
    // Retrieve
    if some_key, ok := some_map["key"]; ok {
        // Here, as with Lisp, hashtable lookup returns a second "status" value
        //   which says whether or not the lookup was successful.
        value := some_key
        value += 0
    }

    // Map short-hand
    _ = map[string]string {
        "H": "Hydrogen",
        "He": "Helium",
    }


// == FUNCTIONS ==
    a4 := []float64 { 1, 2, 3, 4 }

// Continued below in
    average(a4)

    _, _, _ = multipleReturns()

    addAll(1, 2, 3, 4, 5, 6)

    main2()
}

// Can name the return value  |
//                            v
func average(vect []float64) (result float64) {
    var sum float64 = 0.0
    for _, value := range vect {
        sum += value
    }
    result = sum / float64(len(vect)) // Assign result to return value
    return
}

func multipleReturns() (int, int, int) {
    return 1, 2, 3
}

// Varargs
func addAll(args ...int) int {
    total := 0
    for _, v := range args {
        total += v
    }
    return total
}

// Generator
func makeEvenGenerator() func() uint {
    i := uint(0)
    return func() (ret uint) {
        ret = i
        i += 2
        return
    }
}

func main2() {
    // lambdas
    add := func (x, y int) int {
        return x + y
    }
    add(1, 2) // 3

    nextEven := makeEvenGenerator()
    fmt.Println(nextEven()) // 0
    fmt.Println(nextEven()) // 2
    fmt.Println(nextEven()) // 4


// (Skipped section on Recursion)


// == DEFER, PANIC, RECOVER ==
    defer multipleReturns() // Schedules `multipleReturns` to run after this
                            //   function returns. Often used to close
                            //   resources

    defer func() {
        // Need to defer this because panic stops execution of function
        str := recover() // Catches panic
        fmt.Println(str)
    }() // <- Note trailing "()"
    panic("PANIC!!!") // throws a runtime error


// == POINTERS ==
    some_value := 5
    *(&some_value) = 6 // The *value* at the *address of* some_value = 6

    // `new` allocates enough memory to fit a value of specified type and
    //   returns a ptr to it. Go is garbage collected; do not need to worry
    //   about deleting objects created with `new`.
    int_ptr := new(int)
    *int_ptr = 0


// == STRUCTS AND INTERFACES ==
    type Circle struct {
        x, y, r float64
    }

    // TODO Copied directly from the tutorial, compiler doesn't like this
    //func (c *Circle) area() float64 {
    //    return math.Pi * circle.r * circle.r
    //}

    // Create an instance of Circle with all values set to 0.0 (default)
    var c1 Circle
    c1.x = 10

    // Create a ptr to a Circle
    c2 := new(Circle)
    c2.y = 5

    // Create a Circle using labelled args
    c3 := Circle { x: 0, y: 0, r: 5 }
    c3.r = 7

    // Use the order that the fields were defined in
    c4 := Circle { 0, 0, 5 }
    c4.x = 2

    // Embedded type: CoolCircle "is-a" Circle
    // Anonymous field, similar to Python?
    // Can call methods explicitly, e.g. coolCirc.Circle.area()
    // Or also just use inherited methods directly, coolCirc.area()
    type CoolCircle struct {
        Circle
        x, y, r float64
    }

    // Interface, similar to Java
    // All types that implement this "method set" are accepted
    type Shape interface {
        area() float64
    }


// == Concurrency ==
    // Goroutines: created using `go <func call>`. Runs concurrently with other
    //             functions.
    some_goroutine := func (n int) {
        for i := n; i < 10; i++ {
            // Do something
        }
    }
    go some_goroutine(0)

    // Channels: way goroutines communicate with each other
    //   func some_func(c chan<- string)   restricted to receiving
    //   func some_func(c <-chan string)   restricted to sending
    ping_pong := func (id int, c chan string) {
        if id % 2 == 1 {
            <-c
        }
        for i := 0; i < 5; i++ {
            c <- "msg"
            <-c
        }
        if id % 2 == 0 {
            c <- "msg"
        }
    }
    var c chan string = make(chan string)
    go ping_pong(0, c)
    go ping_pong(1, c)

    // Select: switch for channels
    //         Randomly picks to send/receive from ready channels, else blocks
    var chan2 chan string = make(chan string)
    go func () {
        for {
            select {
            case msg1 := <-c:
                fmt.Println(msg1)
            case msg2 := <-chan2:
                fmt.Println(msg2)
            case <- time.After(time.Second): // timeout case
                fmt.Println("timeout")
            }
        }
    }()

    // Buffered Channel: sets a capacity on channel, makes it async
    _ = make(chan int, 5)

// == PACKAGES ==
    // - Define package using `package`
    // - `go install` compiles package
    // - `import m "some/package/path"` imports some package under `m` alias
    // - Convention: Capitalized functions can be seen by other packages


// == TESTING ==
    // In file "<pkg>_test.go":
    _ = func (t *testing.T) {
        var v float64
        v = average([]float64{ 1, 2 })
        if v != 1.5 {
            t.Error("Expected 1.5, got ", v)
        }
    }
    // Run `go test` to test
}
