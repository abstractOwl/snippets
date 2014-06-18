;;
;; Fibonacci sequence
;; Taken from https://github.com/google/lisp-koans
;;
;; Demonstrates ability to work with multiple return values in lisp.
;;

; Fibonacci function
(defun fibonacci(a b)
    (values b (+ a b)))

; Basic fibonacci
(fibonacci 1 2)

; Perform (+ x y), where (x y) is output of (fib 1 2)
(multiple-value-bind (x y) (fibonacci 1 2) (+ x y))

; Set (x y) to output of (fib 1 2)
(let ((x) (y))
    (multiple-value-setq (x y) (fibonacci 1 2))
)

