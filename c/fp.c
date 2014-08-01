#include <stdio.h>

/**
 * Evaluate a binary operation.
 *
 * @param (*binaryFn) A function that takes 2 params.
 * @param x The LHS param.
 * @param y The RHS param.
 * @return The int result of a binary function.
 */
int binaryOp(int (*binaryFn)(int, int), int x, int y)
{
    return (*binaryFn)(x, y);
}

/**
 * Returns the sum of two numbers.
 *
 * @param x The LHS param.
 * @param y The RHS param.
 * @return The integer sum.
 */
int sum(int x, int y)
{
    return x + y;
}

/**
 * Returns the product of two numbers.
 *
 * @param x The LHS param.
 * @param y The RHS param.
 * @return The integer product.
 */
int product(int x, int y)
{
    return x * y;
}

// main function
int main(void)
{
    printf(
        "2 + 4 = %d\n",
        binaryOp(*sum, 2, 4)
    );

    printf(
        "7 * 3 = %d\n",
        binaryOp(*product, 7, 3)
    );

    return 0;
}
